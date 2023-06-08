package e.commerce.ecommerce.api.controller;

import e.commerce.ecommerce.business.abstracts.InvoiceService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateInvoiceRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateInvoiceRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateInvoiceResponse;
import e.commerce.ecommerce.business.dto.responses.gets.invoice.GetAllInvoicesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.invoice.GetInvoiceResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateInvoiceResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoicesController {
    private final InvoiceService service;

    @GetMapping
    public List<GetAllInvoicesResponse> getAll ()
    { return service.getAll(); }

    @GetMapping("/{id}")
    public GetInvoiceResponse getById (@PathVariable int id)
    { return service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateInvoiceResponse add (@Valid @RequestBody CreateInvoiceRequest request)
    { return service.add(request); }

    @PutMapping("/{id}")
    public UpdateInvoiceResponse update (@PathVariable int id, @Valid @RequestBody UpdateInvoiceRequest request)
    { return service.update(id, request); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable int id)
    {service.delete(id);}
}