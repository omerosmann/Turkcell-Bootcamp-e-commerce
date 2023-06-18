package e.commerce.ecommerce.business.concretes;



import e.commerce.ecommerce.business.abstracts.IndividualCustomerService;
import e.commerce.ecommerce.business.abstracts.UserService;
import e.commerce.ecommerce.business.dto.requests.AuthRequest;
import e.commerce.ecommerce.business.dto.requests.PasswordRequest;
import e.commerce.ecommerce.business.dto.requests.ResetPasswordRequest;
import e.commerce.ecommerce.business.dto.requests.TokenPasswordRequest;
import e.commerce.ecommerce.business.dto.requests.creates.CreateIndividualCustomerRequest;
import e.commerce.ecommerce.business.dto.responses.AuthResponse;
import e.commerce.ecommerce.business.dto.responses.PasswordResponse;
import e.commerce.ecommerce.business.dto.responses.ResetPasswordResponse;
import e.commerce.ecommerce.business.dto.responses.TokenResetResponse;
import e.commerce.ecommerce.business.dto.responses.creates.CreateIndividualCustomerResponse;
import e.commerce.ecommerce.business.dto.responses.gets.IndividualCustomer.GetAllIndividualCustomerResponse;
import e.commerce.ecommerce.business.dto.responses.gets.IndividualCustomer.GetIndividualCustomerResponse;
import e.commerce.ecommerce.business.rules.IndividualCustomerBusinessRules;
import e.commerce.ecommerce.business.rules.UserBusinessRules;
import e.commerce.ecommerce.core.utils.email.EmailService;
import e.commerce.ecommerce.core.utils.passwordToken.TokenGenerator;
import e.commerce.ecommerce.entities.IndividualCustomer;
import e.commerce.ecommerce.entities.User;
import e.commerce.ecommerce.repository.IndividualCustomerRepository;
import e.commerce.ecommerce.security.CustomUserDetail;
import e.commerce.ecommerce.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final TokenGenerator tokenGenerator;
    private final EmailService emailService;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private final UserBusinessRules userBusinessRules;

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        Authentication authentication =
                authenticationManager.authenticate
                        (new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();

        return new AuthResponse(jwt);
    }

    @Override
    public CreateIndividualCustomerResponse register
            (CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        IndividualCustomer individualCustomer =
                modelMapper.map(createIndividualCustomerRequest, IndividualCustomer.class);
        individualCustomer.setId(0);
        individualCustomer.setPassword(passwordEncoder.encode(createIndividualCustomerRequest.getPassword()));
        individualCustomerRepository.save(individualCustomer);

        CreateIndividualCustomerResponse createIndividualCustomerResponse =
                modelMapper.map(individualCustomer, CreateIndividualCustomerResponse.class);

        return createIndividualCustomerResponse;
    }

    @Override
    public GetIndividualCustomerResponse getById(int id) {
        userBusinessRules.checkIfUserExistsById(id);
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).orElseThrow();
        GetIndividualCustomerResponse getIndividualCustomerResponse =
                modelMapper.map(individualCustomer, GetIndividualCustomerResponse.class);

        return getIndividualCustomerResponse;
    }

    @Override
    public List<GetAllIndividualCustomerResponse> getAll() {
        List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAll();
        List<GetAllIndividualCustomerResponse> getAllIndividualCustomerResponses = individualCustomers
                .stream()
                .map(individualCustomer -> modelMapper.map(individualCustomer, GetAllIndividualCustomerResponse.class))
                .collect(Collectors.toList());

        return getAllIndividualCustomerResponses;
    }

    @Override
    public void delete(int id) {
        userBusinessRules.checkIfUserExistsById(id);
        individualCustomerRepository.deleteById(id);
    }

    @Override
    public PasswordResponse changePassword(PasswordRequest passwordRequest) {
        User user = userService.getByEmail(passwordRequest.getEmail());

        individualCustomerBusinessRules.checkPasswords(passwordRequest.getOldPassword(),
                user.getPassword());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String encodedNewPassword = bCryptPasswordEncoder.encode(passwordRequest.getNewPassword());
        user.setPassword(encodedNewPassword);

        userService.add(user);

        PasswordResponse passwordResponse = modelMapper.map(passwordRequest, PasswordResponse.class);

        return passwordResponse;
    }

    @Override
    public ResetPasswordResponse resetPassword(String token, TokenPasswordRequest tokenPasswordRequest) {
        User user = userService.getByResetToken(token);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setPassword(bCryptPasswordEncoder.encode(tokenPasswordRequest.getPassword()));
        user.setResetToken(null);

        userService.add(user);

        ResetPasswordResponse resetPasswordResponse =
                modelMapper.map(user, ResetPasswordResponse.class);

        return resetPasswordResponse;
    }

    @Override
    public TokenResetResponse forgotPassword(ResetPasswordRequest createResetPasswordRequest) {
        User user = userService.getByEmail(createResetPasswordRequest.getEmail());

        user.setResetToken(tokenGenerator.generateToken());

        userService.add(user);

        TokenResetResponse tokenResetResponse = new TokenResetResponse();
        tokenResetResponse.setUrlWithToken("http://localhost:8080/api/individualcustomers/resetPassword?token=" +
                user.getResetToken());

        emailService.sendEmail(user.getEmail(), tokenResetResponse.getUrlWithToken());

        return tokenResetResponse;
    }

}
