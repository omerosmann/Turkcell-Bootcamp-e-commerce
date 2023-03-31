package kodlama.io.ecommerce.api.controller;

import kodlama.io.ecommerce.business.abstracts.PhoneService;
import kodlama.io.ecommerce.business.dto.requests.create.CreatePhoneRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdatePhoneRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreatePhoneResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllPhonesResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetPhoneResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdatePhoneResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
@AllArgsConstructor
public class PhonesController {
    private final PhoneService phoneService;

    @GetMapping
    public List<GetAllPhonesResponse> getAll(){
        return phoneService.getAll();
    }

    @GetMapping("/{id}")
    public GetPhoneResponse getById(@PathVariable long id) {
        return phoneService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePhoneResponse add(@RequestBody CreatePhoneRequest request){
        return phoneService.add(request);
    }

    @PutMapping("/{id}")
    public UpdatePhoneResponse update(@PathVariable long id, @RequestBody UpdatePhoneRequest request){
        return phoneService.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id)   {
        phoneService.delete(id);
    }

}
