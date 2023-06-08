package e.commerce.ecommerce.business.rules;

import e.commerce.ecommerce.common.constants.Messages;
import e.commerce.ecommerce.core.exceptions.BusinessException;
import e.commerce.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository repository;

    public void checkIfProductExists(int id)
    { if (!repository.existsById(id)) throw new BusinessException(Messages.Product.NotExists); }

    public void checkIfPriceValue(double price)
    { if (price <= 0) throw new BusinessException(Messages.Product.Price); }

    public void checkIfQuantityValue(int quantity)
    { if (quantity < 0 ) throw new BusinessException(Messages.Product.Quantity); }

    public void checkIfDescriptionValue (String description)
    { if ((description.length() < 10) || (description.length() >50 ))
        throw new BusinessException(Messages.Product.DescriptionLength); }
}