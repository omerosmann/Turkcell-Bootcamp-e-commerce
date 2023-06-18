package e.commerce.ecommerce.business.abstracts;


import e.commerce.ecommerce.entities.User;

public interface UserService {
    User getByEmail(String email);
    User getByResetToken(String token);
    void add(User user);
}
