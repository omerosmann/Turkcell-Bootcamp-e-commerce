package kodlama.io.ecommerce.api.controller;


import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateProductRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateProductRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateProductResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllProductsResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetProductResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
//@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @GetMapping
    public List<GetAllProductsResponse> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable long id) {
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request){
         return productService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable long id, @RequestBody UpdateProductRequest request){
        return productService.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id)   {
        productService.delete(id);
    }

}
