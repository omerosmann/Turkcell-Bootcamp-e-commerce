package e.commerce.ecommerce.business.abstracts;

import e.commerce.ecommerce.business.dto.requests.creates.CreatePaymentRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdatePaymentRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreatePaymentResponse;
import e.commerce.ecommerce.business.dto.responses.gets.payment.GetAllPaymentsResponse;
import e.commerce.ecommerce.business.dto.responses.gets.payment.GetPaymentResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdatePaymentResponse;
import e.commerce.ecommerce.common.dto.CreateSalePaymentRequest;

import java.util.List;

public interface PaymentService {
    List<GetAllPaymentsResponse> getAll();
    GetPaymentResponse getById(int id);
    CreatePaymentResponse add(CreatePaymentRequest request);
    UpdatePaymentResponse update(int id, UpdatePaymentRequest request);
    void processSalePayment(CreateSalePaymentRequest request);
    void delete(int id);
}