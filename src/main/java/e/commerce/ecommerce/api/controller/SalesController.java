package e.commerce.ecommerce.api.controller;

import e.commerce.ecommerce.business.abstracts.SaleService;
import e.commerce.ecommerce.business.abstracts.ShipService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateSaleRequest;
import e.commerce.ecommerce.business.dto.requests.creates.CreateShipRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateSaleRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateShipRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateSaleResponse;
import e.commerce.ecommerce.business.dto.responses.creates.CreateShipResponse;
import e.commerce.ecommerce.business.dto.responses.gets.sale.GetAllSalesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.sale.GetSaleResponse;
import e.commerce.ecommerce.business.dto.responses.gets.ship.GetAllShipsResponse;
import e.commerce.ecommerce.business.dto.responses.gets.ship.GetShipResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateSaleResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateShipResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sales")
public class SalesController {
    private final SaleService service;

    @GetMapping
    public List<GetAllSalesResponse> getAll()
    { return service.getAll(); }

    @GetMapping("/{id}")
    public GetSaleResponse getById(@PathVariable int id)
    { return  service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSaleResponse add (@Valid @RequestBody CreateSaleRequest request)
    { return service.add(request); }

    @PutMapping("/{id}")
    public UpdateSaleResponse update(@PathVariable int id, @Valid @RequestBody UpdateSaleRequest request)
    { return service.update(id, request); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    { service.delete(id); }
}
