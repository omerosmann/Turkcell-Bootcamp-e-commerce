package e.commerce.ecommerce.business.dto.requests.updates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSaleRequest {
    private int productId;
    private int price;
    private int quantity;
    private LocalDateTime saleTime;
}

