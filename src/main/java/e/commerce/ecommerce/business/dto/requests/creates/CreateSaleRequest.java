package e.commerce.ecommerce.business.dto.requests.creates;

import e.commerce.ecommerce.business.dto.requests.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleRequest {
    private int productId;
    private int price;
    private int quantity;
    private LocalDateTime saleTime;

    private PaymentRequest paymentRequest; // Card Information
}