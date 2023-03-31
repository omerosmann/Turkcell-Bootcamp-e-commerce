package kodlama.io.ecommerce.api.controller;

import kodlama.io.ecommerce.business.abstracts.BrandService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateBrandRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetBrandResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private final BrandService brandService;

    @GetMapping
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandResponse getById(@PathVariable long id) {
        return brandService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add(@RequestBody CreateBrandRequest request){
        return brandService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponse update(@PathVariable long id, @RequestBody UpdateBrandRequest request){
        return brandService.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id)   {
        brandService.delete(id);
    }
}

