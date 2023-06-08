package e.commerce.ecommerce.api.controller;

import e.commerce.ecommerce.business.abstracts.CategoryService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateCategoryRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateCategoryRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateCategoryResponse;
import e.commerce.ecommerce.business.dto.responses.gets.category.GetAllCategoriesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.category.GetCategoryResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping ("/api/categories")
public class CategoriesController {
    private final CategoryService service;

    @GetMapping
    public List<GetAllCategoriesResponse> getAll()
    { return service.getAll(); }

    @GetMapping ("/{id}")
    public GetCategoryResponse getById (@PathVariable int id)
    { return service.getById(id); }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public CreateCategoryResponse add (@Valid @RequestBody CreateCategoryRequest request)
    { return service.add(request); }

    @PutMapping ("/{id}")
    public UpdateCategoryResponse update (@PathVariable int id, @Valid @RequestBody UpdateCategoryRequest request)
    { return service.update(id, request); }

    @DeleteMapping ("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete (@PathVariable int id)
    { service.delete(id); }
}
