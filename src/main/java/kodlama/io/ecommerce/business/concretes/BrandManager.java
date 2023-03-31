package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.BrandService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdateBrandRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetBrandResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateBrandResponse;
import kodlama.io.ecommerce.entities.Brand;
import kodlama.io.ecommerce.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> response = brands.stream()
                .map(brand -> mapper.map(brand, GetAllBrandsResponse.class)).toList();
        return response;
    }

    @Override
    public GetBrandResponse getById(long id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        brand.setId(id);
        GetBrandResponse response = mapper.map(brand, GetBrandResponse.class);
        return response;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {
        Brand brand = mapper.map(request, Brand.class);
        brand.setId(0);
        brandRepository.save(brand);
        CreateBrandResponse response = mapper.map(brand,CreateBrandResponse.class);
        return response;
    }

    @Override
    public UpdateBrandResponse update(long id, UpdateBrandRequest request) {
        Brand brand = mapper.map(request,Brand.class);
        brand.setId(id);
        brandRepository.save(brand);
        UpdateBrandResponse brandResponse = mapper.map(brand, UpdateBrandResponse.class);
        return brandResponse;
    }

    @Override
    public void delete(long id) {
        brandRepository.deleteById(id);
    }
}

