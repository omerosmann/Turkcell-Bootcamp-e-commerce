package e.commerce.ecommerce.business.concretes;

import e.commerce.ecommerce.business.abstracts.CategoryService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateCategoryRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateCategoryRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateCategoryResponse;
import e.commerce.ecommerce.business.dto.responses.gets.category.GetAllCategoriesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.category.GetCategoryResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateCategoryResponse;
import e.commerce.ecommerce.business.rules.CategoryBusinessRules;
import e.commerce.ecommerce.entities.Category;
import e.commerce.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final ModelMapper mapper;
    private final CategoryRepository repository;
    private final CategoryBusinessRules rules;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = repository.findAll();

        List<GetAllCategoriesResponse> responses = categories
                .stream()
                .map(category -> mapper.map(category, GetAllCategoriesResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetCategoryResponse getById(int id) {
        rules.checkIfCategoryExists(id);

        Category category = repository.findById(id).orElseThrow();

        GetCategoryResponse response = mapper.map(category, GetCategoryResponse.class);

        return response;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        rules.CheckIfCategoryNameLength(request.getName());

        Category category = mapper.map(request, Category.class);

        category.setId(0);
        repository.save(category);

        CreateCategoryResponse response = mapper.map(category, CreateCategoryResponse.class);

        return response;
    }

    @Override
    public UpdateCategoryResponse update(int id, UpdateCategoryRequest request) {
        rules.checkIfCategoryExists(id);
        rules.CheckIfCategoryNameLength(request.getName());

        Category category = mapper.map(request, Category.class);

        category.setId(id);
        repository.save(category);

        UpdateCategoryResponse response = mapper.map(category, UpdateCategoryResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfCategoryExists(id);

        repository.deleteById(id); }
}