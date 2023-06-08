package e.commerce.ecommerce.business.concretes;

import e.commerce.ecommerce.business.abstracts.ShipService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateShipRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateShipRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateShipResponse;
import e.commerce.ecommerce.business.dto.responses.gets.ship.GetAllShipsResponse;
import e.commerce.ecommerce.business.dto.responses.gets.ship.GetShipResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateShipResponse;
import e.commerce.ecommerce.business.rules.ShipBusinessRules;
import e.commerce.ecommerce.entities.Ship;
import e.commerce.ecommerce.repository.ShipRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShipManager implements ShipService {
    private final ModelMapper mapper;
    private final ShipBusinessRules rules;
    private final ShipRepository repository;


    @Override
    public List<GetAllShipsResponse> getAll() {
        List<Ship> ships = repository.findAll();

        List<GetAllShipsResponse> responses = ships
                .stream()
                .map(ship -> mapper.map(ship, GetAllShipsResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetShipResponse getById(int id) {
        rules.checkIfShipExists(id);

        Ship ship = repository.findById(id).orElseThrow();

        GetShipResponse response = mapper.map(ship, GetShipResponse.class);

        return response;
    }

    @Override
    public CreateShipResponse add(CreateShipRequest request) {
        rules.checkIfShipNoLength(request.getShipNo());

        Ship ship = mapper.map(request, Ship.class);

        ship.setId(0);
        repository.save(ship);

        CreateShipResponse response = mapper.map(ship, CreateShipResponse.class);

        return response;
    }

    @Override
    public UpdateShipResponse update(int id, UpdateShipRequest request) {
        rules.checkIfShipExists(id);

        Ship ship = mapper.map(request, Ship.class);

        ship.setId(id);
        repository.save(ship);

        UpdateShipResponse response = mapper.map(ship, UpdateShipResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfShipExists(id);

        repository.deleteById(id);
    }
}
