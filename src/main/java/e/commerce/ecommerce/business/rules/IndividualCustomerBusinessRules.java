package e.commerce.ecommerce.business.rules;



import e.commerce.ecommerce.repository.IndividualCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndividualCustomerBusinessRules {
    private final IndividualCustomerRepository individualCustomerRepository;
    public void checkPasswords(String oldPassword, String userPassword){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (!bCryptPasswordEncoder.matches(oldPassword, userPassword)){
            throw new RuntimeException("Incorrect Password");
        }
    }
}
