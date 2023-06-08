package e.commerce.ecommerce.business.abstracts;

import e.commerce.ecommerce.business.dto.requests.creates.CreateSaleRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateSaleRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateSaleResponse;
import e.commerce.ecommerce.business.dto.responses.gets.sale.GetAllSalesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.sale.GetSaleResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateSaleResponse;

import java.util.List;

public interface SaleService {
    List<GetAllSalesResponse> getAll();
    GetSaleResponse getById(int id);
    CreateSaleResponse add(CreateSaleRequest request);
    UpdateSaleResponse update(int id, UpdateSaleRequest request);
    void delete(int id);
}
