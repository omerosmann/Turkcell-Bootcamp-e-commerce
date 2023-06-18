package e.commerce.ecommerce.business.concretes;



import e.commerce.ecommerce.business.abstracts.UserService;
import e.commerce.ecommerce.business.rules.UserBusinessRules;
import e.commerce.ecommerce.entities.User;
import e.commerce.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;

    private final UserBusinessRules userBusinessRules;
    @Override
    public User getByEmail(String email) {
        userBusinessRules.checkIfUserExistsByEmail(email);
        User user = userRepository.findByEmail(email).orElseThrow();

        return user;
    }

    @Override
    public User getByResetToken(String token) {
        User user = userRepository.findByResetToken(token).orElseThrow();
        return user;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

}
