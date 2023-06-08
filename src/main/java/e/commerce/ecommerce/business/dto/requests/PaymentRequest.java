package e.commerce.ecommerce.business.dto.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    @NotBlank(message = "Card number cannot be left blank.")
    @Length(min = 16, max = 16, message = "The card number must consist of 16 digits.")
    private String cardNumber;

    @NotBlank
    @Length(min = 5)
    private String cardHolder;

    @Min(value = 1)
    @Max(value = 12)
    private int cardExpirationMonth;

    @Max(value = 2023)
    private int cardExpirationYear;

    @NotBlank
    @Length(min = 3, max = 4)
    private String cardCvv;
}