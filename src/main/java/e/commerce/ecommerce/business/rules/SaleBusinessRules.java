package e.commerce.ecommerce.business.rules;

import e.commerce.ecommerce.common.constants.Messages;
import e.commerce.ecommerce.core.exceptions.BusinessException;
import e.commerce.ecommerce.entities.enums.State;
import e.commerce.ecommerce.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaleBusinessRules {
    private final SaleRepository repository;

    public void checkIfSaleExists(int id)
    { if (!repository.existsById(id)) throw new BusinessException(Messages.Sale.NotExists); }

    public void checkIfQuantity(int quantity)
    { if (quantity <= 0) throw new BusinessException(Messages.Sale.NotQuantity); }

    public void checkIfState (State state)
    { if(state.equals(State.PASSIVE)) throw new BusinessException(Messages.Sale.NotActive); }
}