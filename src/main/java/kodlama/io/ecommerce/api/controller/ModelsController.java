package kodlama.io.ecommerce.api.controller;

import kodlama.io.ecommerce.business.abstracts.ModelService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateModelRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateModelRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateModelResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllModelsResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetModelResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

    private final ModelService modelService;

    @GetMapping
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetModelResponse getById(@PathVariable long id) {
        return modelService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse add(@RequestBody CreateModelRequest request){
        return modelService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateModelResponse update(@PathVariable long id, @RequestBody UpdateModelRequest request){
        return modelService.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id)   {
        modelService.delete(id);
    }

}
