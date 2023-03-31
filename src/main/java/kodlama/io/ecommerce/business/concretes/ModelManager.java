package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ModelService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateModelRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateModelRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateModelResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllModelsResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetModelResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateModelResponse;
import kodlama.io.ecommerce.entities.Model;
import kodlama.io.ecommerce.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> response = models.stream().
                map(model -> mapper.map(model, GetAllModelsResponse.class)).toList();

        return response;
    }

    @Override
    public GetModelResponse getById(long id) {
        Model model = modelRepository.findById(id).orElseThrow();
        model.setId(id);
        GetModelResponse response = mapper.map(model,GetModelResponse.class);
        return response;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        Model model = mapper.map(request,Model.class);
        model.setId(0);
        modelRepository.save(model);
        CreateModelResponse response = mapper.map(model,CreateModelResponse.class);
        return response;
    }

    @Override
    public UpdateModelResponse update(long id, UpdateModelRequest request) {
        Model model = mapper.map(request,Model.class);
        model.setId(id);
        modelRepository.save(model);
        UpdateModelResponse modelResponse = mapper.map(model,UpdateModelResponse.class);
        return modelResponse;
    }

    @Override
    public void delete(long id) {
        modelRepository.deleteById(id);
    }
}
