package e.commerce.ecommerce.business.dto.responses.gets.product;

import e.commerce.ecommerce.entities.enums.State;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductResponse {
    private int id;
    private String name;
    private State state;
    private int quantity;
    private double price;
    private String description;
}
