package e.commerce.ecommerce.business.abstracts;

import e.commerce.ecommerce.business.dto.requests.creates.CreateShipRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateShipRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateShipResponse;
import e.commerce.ecommerce.business.dto.responses.gets.ship.GetAllShipsResponse;
import e.commerce.ecommerce.business.dto.responses.gets.ship.GetShipResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateShipResponse;

import java.util.List;

public interface ShipService {
    List<GetAllShipsResponse> getAll();
    GetShipResponse getById(int id);
    CreateShipResponse add(CreateShipRequest request);
    UpdateShipResponse update(int id, UpdateShipRequest request);
    void delete(int id);
}
