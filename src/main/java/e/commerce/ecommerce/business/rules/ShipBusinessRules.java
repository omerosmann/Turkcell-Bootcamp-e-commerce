package e.commerce.ecommerce.business.rules;

import e.commerce.ecommerce.common.constants.Messages;
import e.commerce.ecommerce.core.exceptions.BusinessException;
import e.commerce.ecommerce.repository.ShipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShipBusinessRules {
    ShipRepository repository;

    public void checkIfShipExists(int id)
    { if (!repository.existsById(id)) throw new BusinessException(Messages.Ship.NotExists); }

    public void checkIfShipNoLength(String shipNo)
    { if (shipNo.length() <= 0) throw new BusinessException(Messages.Ship.ShipNoLength); }
}
