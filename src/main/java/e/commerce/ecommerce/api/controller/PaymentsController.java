package e.commerce.ecommerce.api.controller;

import e.commerce.ecommerce.business.abstracts.PaymentService;
import e.commerce.ecommerce.business.abstracts.SaleService;
import e.commerce.ecommerce.business.dto.requests.creates.CreatePaymentRequest;
import e.commerce.ecommerce.business.dto.requests.creates.CreateSaleRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdatePaymentRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateSaleRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreatePaymentResponse;
import e.commerce.ecommerce.business.dto.responses.creates.CreateSaleResponse;
import e.commerce.ecommerce.business.dto.responses.gets.payment.GetAllPaymentsResponse;
import e.commerce.ecommerce.business.dto.responses.gets.payment.GetPaymentResponse;
import e.commerce.ecommerce.business.dto.responses.gets.sale.GetAllSalesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.sale.GetSaleResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdatePaymentResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateSaleResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentsController {
    private final PaymentService service;

    @GetMapping
    public List<GetAllPaymentsResponse> getAll()
    { return service.getAll(); }

    @GetMapping("/{id}")
    public GetPaymentResponse getById(@PathVariable int id)
    { return  service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePaymentResponse add (@Valid @RequestBody CreatePaymentRequest request)
    { return service.add(request); }

    @PutMapping("/{id}")
    public UpdatePaymentResponse update(@PathVariable int id, @Valid @RequestBody UpdatePaymentRequest request)
    { return service.update(id, request); }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    { service.delete(id); }
}
