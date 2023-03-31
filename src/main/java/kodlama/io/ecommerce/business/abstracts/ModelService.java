package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateModelRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateModelRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateModelResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllModelsResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetModelResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateModelResponse;

import java.util.List;

public interface ModelService {

    List<GetAllModelsResponse> getAll();

    GetModelResponse getById(long id);

    CreateModelResponse add(CreateModelRequest request);

    UpdateModelResponse update(long id, UpdateModelRequest request);
    void delete(long id);

}
