package e.commerce.ecommerce.api.controller;

import e.commerce.ecommerce.business.abstracts.ProductService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateProductRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateProductRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateProductResponse;
import e.commerce.ecommerce.business.dto.responses.gets.product.GetAllProductsResponse;
import e.commerce.ecommerce.business.dto.responses.gets.product.GetProductResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService service;

    @GetMapping
    public List<GetAllProductsResponse> getAll(@RequestParam (defaultValue = "true") boolean includeState)
    { return service.getAll(includeState); }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable int id)
    { return service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request)
    { return service.add(request); }

    @PutMapping ("/{id}")
    public UpdateProductResponse update(@PathVariable int id, @RequestBody UpdateProductRequest request)
    { return service.update(id, request); }

    @PutMapping("/state")
    public GetProductResponse stateChange (@RequestParam int id)
    { return service.productStateChange(id); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable int id)
    { service.delete(id); }
}