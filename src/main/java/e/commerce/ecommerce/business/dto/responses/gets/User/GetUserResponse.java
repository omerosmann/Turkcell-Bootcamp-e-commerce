package e.commerce.ecommerce.business.dto.responses.gets.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponse {
    private int id;
    private String email;
    private String password;
    private String resetToken;
}
