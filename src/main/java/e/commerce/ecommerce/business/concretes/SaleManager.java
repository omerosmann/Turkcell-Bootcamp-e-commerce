package e.commerce.ecommerce.business.concretes;

import e.commerce.ecommerce.business.abstracts.InvoiceService;
import e.commerce.ecommerce.business.abstracts.PaymentService;
import e.commerce.ecommerce.business.abstracts.ProductService;
import e.commerce.ecommerce.business.abstracts.SaleService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateInvoiceRequest;
import e.commerce.ecommerce.business.dto.requests.creates.CreateSaleRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateSaleRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateSaleResponse;
import e.commerce.ecommerce.business.dto.responses.gets.sale.GetAllSalesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.sale.GetSaleResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateSaleResponse;
import e.commerce.ecommerce.business.rules.SaleBusinessRules;
import e.commerce.ecommerce.common.dto.CreateSaleInvoiceRequest;
import e.commerce.ecommerce.common.dto.CreateSalePaymentRequest;
import e.commerce.ecommerce.entities.Product;
import e.commerce.ecommerce.entities.Sale;
import e.commerce.ecommerce.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleManager implements SaleService {
    private final ModelMapper mapper;
    private final SaleBusinessRules rules;
    private final PaymentService paymentService;
    private final SaleRepository saleRepository;
    private final ProductService productService;


    @Override
    public List<GetAllSalesResponse> getAll() {
        List<Sale> sales = saleRepository.findAll();

        List<GetAllSalesResponse> responses = sales
                .stream()
                .map(sale -> mapper.map(sale, GetAllSalesResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetSaleResponse getById(int id) {
        rules.checkIfSaleExists(id);

        Sale sale = saleRepository.findById(id).orElseThrow();

        GetSaleResponse response = mapper.map(sale, GetSaleResponse.class);

        return response;
    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request) {
        Product product = mapper.map(productService.getById(request.getProductId()), Product.class);
        rules.checkIfState(product.getState());
        rules.checkIfQuantity(product.getQuantity());

        Sale sale = mapper.map(request, Sale.class);

        sale.setId(0);
        sale.setTotalPrice(sale.getPrice() * sale.getQuantity());

        CreateSalePaymentRequest salePaymentRequest = new CreateSalePaymentRequest();
        salePaymentRequest.setProductId(request.getProductId());
        mapper.map(request.getPaymentRequest(), salePaymentRequest);

        sale.setProduct(product);
        salePaymentRequest.setPrice(sale.getTotalPrice());
        paymentService.processSalePayment(salePaymentRequest); // Payment Step

        saleRepository.save(sale);


        CreateSaleResponse response = mapper.map(sale, CreateSaleResponse.class);
        response.setPrice(product.getPrice());

        return response;
    }

    @Override
    public UpdateSaleResponse update(int id, UpdateSaleRequest request) {
        rules.checkIfSaleExists(id);

        Sale sale = mapper.map(request, Sale.class);

        sale.setId(id);
        saleRepository.save(sale);

        UpdateSaleResponse response = mapper.map(sale, UpdateSaleResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfSaleExists(id);

        saleRepository.deleteById(id);
    }
}