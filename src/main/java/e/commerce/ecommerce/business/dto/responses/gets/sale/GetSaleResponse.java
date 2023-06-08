package e.commerce.ecommerce.business.dto.responses.gets.sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetSaleResponse {
    private int id;
    private int productId;
    private double price;
    private double totalPrice;
    private int quantity;
    private LocalDateTime saleTime;
}
