package e.commerce.ecommerce.business.abstracts;

import e.commerce.ecommerce.business.dto.requests.creates.CreateInvoiceRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateInvoiceRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateInvoiceResponse;
import e.commerce.ecommerce.business.dto.responses.gets.invoice.GetAllInvoicesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.invoice.GetInvoiceResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateInvoiceResponse;
import e.commerce.ecommerce.common.dto.CreateSaleInvoiceRequest;

import java.util.List;

public interface InvoiceService {
    List<GetAllInvoicesResponse> getAll();
    GetInvoiceResponse getById(int id);
    CreateInvoiceResponse add(CreateInvoiceRequest request);
    UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request);
    void delete(int id);
}