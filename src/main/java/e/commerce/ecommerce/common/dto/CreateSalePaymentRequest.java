package e.commerce.ecommerce.common.dto;

import e.commerce.ecommerce.business.dto.requests.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSalePaymentRequest extends PaymentRequest {
    private double price;
    private int productId;
}