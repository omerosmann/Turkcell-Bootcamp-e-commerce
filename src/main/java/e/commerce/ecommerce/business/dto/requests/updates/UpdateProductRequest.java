package e.commerce.ecommerce.business.dto.requests.updates;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private String name;
    private int quantity;
    private double price;

    @Length(min = 10, max = 50, message = "The description must contain at least 10 characters and at most 50 characters.")
    private String description;
}