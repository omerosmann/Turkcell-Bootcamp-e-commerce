package e.commerce.ecommerce.business.abstracts;




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

import java.util.List;

public interface IndividualCustomerService {
    public AuthResponse login(AuthRequest authRequest);
    public CreateIndividualCustomerResponse register(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    public GetIndividualCustomerResponse getById(int id);
    public List<GetAllIndividualCustomerResponse> getAll();
    public void delete(int id);
    public PasswordResponse changePassword(PasswordRequest passwordRequest);
    public ResetPasswordResponse resetPassword(String token, TokenPasswordRequest createTokenPasswordRequest);
    public TokenResetResponse forgotPassword(ResetPasswordRequest createResetPasswordRequest);
}
