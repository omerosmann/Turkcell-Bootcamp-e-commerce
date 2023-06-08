package e.commerce.ecommerce.business.dto.responses.updates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvoiceResponse {
    private int id;
    private int saleId;
    private String productName;
    private String productDescription;
    private int quantity;
    private double price;
    private double totalPrice;
    private LocalDateTime saleTime;
}
