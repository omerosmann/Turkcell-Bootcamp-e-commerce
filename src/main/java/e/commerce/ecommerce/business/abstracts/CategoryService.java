package e.commerce.ecommerce.business.abstracts;

import e.commerce.ecommerce.business.dto.requests.creates.CreateCategoryRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateCategoryRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateCategoryResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateCategoryResponse;
import e.commerce.ecommerce.business.dto.responses.gets.category.GetCategoryResponse;
import e.commerce.ecommerce.business.dto.responses.gets.category.GetAllCategoriesResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();
    GetCategoryResponse getById(int id);
    CreateCategoryResponse add(CreateCategoryRequest request);
    UpdateCategoryResponse update(int id, UpdateCategoryRequest request);
    void delete(int id);
}