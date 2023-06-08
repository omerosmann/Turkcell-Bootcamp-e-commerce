package e.commerce.ecommerce.business.concretes;

import e.commerce.ecommerce.business.rules.ProductBusinessRules;
import e.commerce.ecommerce.entities.enums.State;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import e.commerce.ecommerce.entities.Product;
import e.commerce.ecommerce.business.abstracts.ProductService;
import e.commerce.ecommerce.business.dto.responses.gets.product.GetProductResponse;
import e.commerce.ecommerce.business.dto.requests.creates.CreateProductRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateProductRequest;
import e.commerce.ecommerce.business.dto.responses.gets.product.GetAllProductsResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateProductResponse;
import e.commerce.ecommerce.business.dto.responses.creates.CreateProductResponse;

import org.modelmapper.ModelMapper;
import e.commerce.ecommerce.repository.ProductRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {
    private final ModelMapper mapper;
    private final ProductRepository repository;
    private final ProductBusinessRules rules;

    @Override
    public List<GetAllProductsResponse> getAll(boolean includeState) {
        List<Product> products = filterProductByState(includeState);

        List<GetAllProductsResponse> response = products
                .stream()
                .map(product -> mapper.map(product, GetAllProductsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetProductResponse getById(int id) {
        rules.checkIfProductExists(id);

        Product product = repository.findById(id).orElseThrow();

        GetProductResponse response = mapper.map(product, GetProductResponse.class);

        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        rules.checkIfPriceValue(request.getPrice());
        rules.checkIfQuantityValue(request.getQuantity());
        rules.checkIfDescriptionValue(request.getDescription());

        Product product = mapper.map(request, Product.class);

        product.setId(0);
        product.setState(State.ACTIVE);
        repository.save(product);

        CreateProductResponse response = mapper.map(product, CreateProductResponse.class);

        return response;
    }

    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest request) {
        rules.checkIfProductExists(id);
        rules.checkIfPriceValue(request.getPrice());
        rules.checkIfQuantityValue(request.getQuantity());
        rules.checkIfDescriptionValue(request.getDescription());

        Product product = mapper.map(request, Product.class);

        product.setId(id);
        repository.save(product);

        UpdateProductResponse response = mapper.map(product, UpdateProductResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfProductExists(id);

        repository.deleteById(id);
    }

    @Override
    public GetProductResponse productStateChange(int id) {
        rules.checkIfProductExists(id);

        Product product = repository.findById(id).orElseThrow();

        product.setId(id);
        stateChange(id, product.getState());
        repository.save(product);

        GetProductResponse response = mapper.map(product, GetProductResponse.class);

        return response;
    }

    private void stateChange(int id, State state){
        Product product = repository.findById(id).orElseThrow();

        if (state.equals(State.ACTIVE) )
        {  product.setState(State.PASSIVE); }
        else
        { product.setState(State.ACTIVE); }
    }

    private List<Product> filterProductByState (boolean includeState){
        if (includeState){ return repository.findAll(); }

        return repository.findAllByStateIsNot(State.PASSIVE);
    }
}