package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.PhoneService;
import kodlama.io.ecommerce.business.dto.requests.create.CreatePhoneRequest;
import kodlama.io.ecommerce.business.dto.requests.update.UpdatePhoneRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreatePhoneResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllPhonesResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetPhoneResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdatePhoneResponse;
import kodlama.io.ecommerce.entities.Phone;
import kodlama.io.ecommerce.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PhoneManager implements PhoneService {
    private final PhoneRepository phoneRepository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllPhonesResponse> getAll() {
        List<Phone> phones = phoneRepository.findAll();
        List<GetAllPhonesResponse> response = phones.stream().
                map(phone -> mapper.map(phone, GetAllPhonesResponse.class)).toList();
        return response;
    }

    @Override
    public GetPhoneResponse getById(long id) {
        checkIfProductExists(id);
        Phone phone = phoneRepository.findById(id).orElseThrow();
        phone.setId(id);
        phoneRepository.save(phone);
        GetPhoneResponse phoneResponse = mapper.map(phone,GetPhoneResponse.class);
        return phoneResponse;
    }

    @Override
    public CreatePhoneResponse add(CreatePhoneRequest request) {
        Phone phone = mapper.map(request,Phone.class);
        phone.setId(0);
        phoneRepository.save(phone);
        validateProduct(request);
        CreatePhoneResponse phoneResponse = mapper.map(phone, CreatePhoneResponse.class);
        return phoneResponse;
    }

    @Override
    public UpdatePhoneResponse update(long id, UpdatePhoneRequest request) {
        Phone phone = mapper.map(request, Phone.class);
        phone.setId(id);
        phoneRepository.save(phone);
        checkIfProductExists(id);
        validateProduct(request);
        UpdatePhoneResponse response = mapper.map(phone, UpdatePhoneResponse.class);
        return response;
    }

    @Override
    public void delete(long id) {
        checkIfProductExists(id);
        phoneRepository.deleteById(id);
    }

    private void validateProduct(CreatePhoneRequest request) {
        checkIfUnitPriceValid(request);
        checkIfQuantityValid(request);
        checkIfDescriptionLengthValid(request);
    }

    private void checkIfUnitPriceValid(CreatePhoneRequest request) {
        if (request.getPrice() <= 0)
            throw new IllegalArgumentException("Price cannot be less than or equal to zero.");
    }

    private void checkIfQuantityValid(CreatePhoneRequest request) {
        if (request.getQuantity() < 0)
            throw new IllegalArgumentException("Quantity cannot be less than zero.");
    }

    private void checkIfDescriptionLengthValid(CreatePhoneRequest request) {
        if (request.getDescription().length() < 10 || request.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters.");
    }

    private void validateProduct(UpdatePhoneRequest request) {
        checkIfUnitPriceValid(request);
        checkIfQuantityValid(request);
        checkIfDescriptionLengthValid(request);
    }

    private void checkIfUnitPriceValid(UpdatePhoneRequest request) {
        if (request.getPrice() <= 0)
            throw new IllegalArgumentException("Price cannot be less than or equal to zero.");
    }

    private void checkIfQuantityValid(UpdatePhoneRequest request) {
        if (request.getQuantity() < 0)
            throw new IllegalArgumentException("Quantity cannot be less than zero.");
    }

    private void checkIfDescriptionLengthValid(UpdatePhoneRequest  request) {
        if (request.getDescription().length() < 10 || request.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters.");
    }

    private void checkIfProductExists(long id) {
        if (!phoneRepository.existsById(id)) throw new RuntimeException("No such product is available!!!");
    }
}
