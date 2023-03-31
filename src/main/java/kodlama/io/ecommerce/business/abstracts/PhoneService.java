package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreatePhoneRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdatePhoneRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreatePhoneResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllPhonesResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetPhoneResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdatePhoneResponse;

import java.util.List;

public interface PhoneService {

    List<GetAllPhonesResponse> getAll();

    GetPhoneResponse getById(long id);

    CreatePhoneResponse add(CreatePhoneRequest request);

    UpdatePhoneResponse update(long id, UpdatePhoneRequest request);

    void delete(long id);

}
