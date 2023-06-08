package e.commerce.ecommerce.business.dto.responses.creates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleResponse {
    private int id;
    private int productId;
    private double price;
    private int quantity;
    private double totalPrice;
    private LocalDateTime saleTime;
}

