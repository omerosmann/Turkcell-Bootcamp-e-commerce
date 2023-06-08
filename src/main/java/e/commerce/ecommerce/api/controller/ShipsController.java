package e.commerce.ecommerce.api.controller;

import e.commerce.ecommerce.business.abstracts.ShipService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateShipRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateShipRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateShipResponse;
import e.commerce.ecommerce.business.dto.responses.gets.ship.GetAllShipsResponse;
import e.commerce.ecommerce.business.dto.responses.gets.ship.GetShipResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateShipResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ships")
public class ShipsController {
    private final ShipService service;

    @GetMapping
    public List<GetAllShipsResponse> getAll()
    { return service.getAll(); }

    @GetMapping("/{id}")
    public GetShipResponse getById(@PathVariable int id)
    { return  service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateShipResponse add (@Valid @RequestBody CreateShipRequest request)
    { return service.add(request); }

    @PutMapping("/{id}")
    public UpdateShipResponse update(@PathVariable int id, @Valid @RequestBody UpdateShipRequest request)
    { return service.update(id, request); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    { service.delete(id); }
}
