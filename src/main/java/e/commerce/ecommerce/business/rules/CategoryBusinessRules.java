package e.commerce.ecommerce.business.rules;

import e.commerce.ecommerce.common.constants.Messages;
import e.commerce.ecommerce.core.exceptions.BusinessException;
import e.commerce.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {
    private final CategoryRepository repository;

    public void checkIfCategoryExists(int id)
    { if (!repository.existsById(id)) throw new BusinessException(Messages.Category.NotExists); }

    public void CheckIfCategoryNameLength (String name)
    { if (name.length() <= 0) throw new BusinessException(Messages.Category.NameLength); }
}