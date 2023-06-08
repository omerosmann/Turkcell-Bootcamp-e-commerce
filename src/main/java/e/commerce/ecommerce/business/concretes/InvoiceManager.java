package e.commerce.ecommerce.business.concretes;

import e.commerce.ecommerce.business.abstracts.InvoiceService;
import e.commerce.ecommerce.business.abstracts.SaleService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateInvoiceRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateInvoiceRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateInvoiceResponse;
import e.commerce.ecommerce.business.dto.responses.gets.invoice.GetAllInvoicesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.invoice.GetInvoiceResponse;
import e.commerce.ecommerce.business.dto.responses.gets.sale.GetSaleResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateInvoiceResponse;
import e.commerce.ecommerce.business.rules.InvoiceBusinessRules;
import e.commerce.ecommerce.common.dto.CreateSaleInvoiceRequest;
import e.commerce.ecommerce.entities.Invoice;
import e.commerce.ecommerce.entities.Sale;
import e.commerce.ecommerce.repository.InvoiceRepository;
import e.commerce.ecommerce.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final ModelMapper mapper;
    private final InvoiceBusinessRules rules;
    private final InvoiceRepository repository;

    @Override
    public List<GetAllInvoicesResponse> getAll() {
        List<Invoice> invoices = repository.findAll();

        List<GetAllInvoicesResponse> responses = invoices
                .stream()
                .map(invoice -> mapper.map(invoice, GetAllInvoicesResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        rules.checkIfInvoiceExists(id);

        Invoice invoice = repository.findById(id).orElseThrow();

        GetInvoiceResponse response = mapper.map(invoice, GetInvoiceResponse.class);

        return response;
    }

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest request) {
        Invoice invoice = mapper.map(request, Invoice.class);

        invoice.setId(0);

        repository.save(invoice);

        CreateInvoiceResponse response = mapper.map(invoice, CreateInvoiceResponse.class);
        response.setTotalPrice(request.getPrice() * request.getQuantity());

        return response;
    }

    @Override
    public UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request) {
        rules.checkIfInvoiceExists(id);

        Invoice invoice = mapper.map(request, Invoice.class);

        invoice.setId(id);
        repository.save(invoice);

        UpdateInvoiceResponse response = mapper.map(invoice, UpdateInvoiceResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfInvoiceExists(id);

        repository.deleteById(id);
    }
}