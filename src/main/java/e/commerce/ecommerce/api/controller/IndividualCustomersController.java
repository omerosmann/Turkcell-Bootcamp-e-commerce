package e.commerce.ecommerce.api.controller;

import e.commerce.ecommerce.business.abstracts.IndividualCustomerService;
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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/individualcustomers")
public class IndividualCustomersController {
    private final IndividualCustomerService individualCustomerService;

    public IndividualCustomersController(IndividualCustomerService individualCustomerService) {
        this.individualCustomerService = individualCustomerService;
    }
    @GetMapping()
    public List<GetAllIndividualCustomerResponse> findAll(){
        return individualCustomerService.getAll();
    }
    @GetMapping("/{id}")
    public GetIndividualCustomerResponse getById(@PathVariable("id") int id){
        return individualCustomerService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreateIndividualCustomerResponse register(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest){
        return individualCustomerService.register(createIndividualCustomerRequest);
    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest){
        return individualCustomerService.login(authRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        individualCustomerService.delete(id);
    }
    @PostMapping("/changePassword")
    public PasswordResponse changePassword(
            @RequestBody PasswordRequest createPasswordRequest){
        return individualCustomerService.changePassword(createPasswordRequest);
    }
    @PostMapping("/forgotPassword")
    public TokenResetResponse forgotPassword(
            @RequestBody ResetPasswordRequest createResetPasswordRequest){
        return individualCustomerService.forgotPassword(createResetPasswordRequest);
    } @PutMapping("/resetPassword")
    public ResetPasswordResponse resetPassword(@RequestParam String token,
                                               @RequestBody TokenPasswordRequest createTokenPasswordRequest){
        return individualCustomerService.resetPassword(token, createTokenPasswordRequest);
    }
}
