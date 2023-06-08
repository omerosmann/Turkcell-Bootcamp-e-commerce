package e.commerce.ecommerce.business.rules;

import e.commerce.ecommerce.common.constants.Messages;
import e.commerce.ecommerce.common.dto.CreateSalePaymentRequest;
import e.commerce.ecommerce.core.exceptions.BusinessException;
import e.commerce.ecommerce.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentBusinessRules {
    private final PaymentRepository repository;

    public void checkIfPaymentExists(int id)
    { if(!repository.existsById(id)) throw new BusinessException(Messages.Payment.NotExists); }

    public void checkIfBalanceEnough(double balance, double price)
    { if (balance < price) throw new BusinessException(Messages.Payment.NotEnough); }

    public void checkIfPaymentIsValid(CreateSalePaymentRequest request) {
        if (!repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
                request.getCardNumber(),
                request.getCardHolder(),
                request.getCardExpirationYear(),
                request.getCardExpirationMonth(),
                request.getCardCvv()
        ))
            throw new BusinessException(Messages.Payment.NotValid);
    }
}
