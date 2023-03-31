package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateBrandRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetBrandResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetBrandResponse getById(long id);
    CreateBrandResponse add(CreateBrandRequest request);

    UpdateBrandResponse update(long id, UpdateBrandRequest request);
    void delete(long id);
}

