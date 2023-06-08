package e.commerce.ecommerce.business.concretes;

import e.commerce.ecommerce.business.abstracts.PaymentService;
import e.commerce.ecommerce.business.abstracts.PosService;
import e.commerce.ecommerce.business.abstracts.ProductService;
import e.commerce.ecommerce.business.dto.requests.creates.CreatePaymentRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdatePaymentRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreatePaymentResponse;
import e.commerce.ecommerce.business.dto.responses.gets.payment.GetAllPaymentsResponse;
import e.commerce.ecommerce.business.dto.responses.gets.payment.GetPaymentResponse;
import e.commerce.ecommerce.business.dto.responses.gets.product.GetProductResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdatePaymentResponse;
import e.commerce.ecommerce.business.rules.PaymentBusinessRules;
import e.commerce.ecommerce.common.dto.CreateSalePaymentRequest;
import e.commerce.ecommerce.entities.Payment;
import e.commerce.ecommerce.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final ModelMapper mapper;
    private final PosService posService;
    private final PaymentBusinessRules rules;
    private final ProductService productService;
    private final PaymentRepository paymentRepository;

    @Override
    public List<GetAllPaymentsResponse> getAll() {
        List<Payment> payments = paymentRepository.findAll();

        List<GetAllPaymentsResponse> responses = payments
                .stream()
                .map(payment -> mapper.map(payment, GetAllPaymentsResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetPaymentResponse getById(int id) {
        rules.checkIfPaymentExists(id);

        Payment payment = paymentRepository.findById(id).orElseThrow();

        GetPaymentResponse response = mapper.map(payment, GetPaymentResponse.class);

        return response;
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        Payment payment = mapper.map(request, Payment.class);

        payment.setId(0);
        paymentRepository.save(payment);

        CreatePaymentResponse response = mapper.map(payment, CreatePaymentResponse.class);

        return response;
    }

    @Override
    public UpdatePaymentResponse update(int id, UpdatePaymentRequest request) {
        rules.checkIfPaymentExists(id);

        Payment payment = mapper.map(request, Payment.class);

        payment.setId(id);
        paymentRepository.save(payment);

        UpdatePaymentResponse response = mapper.map(request, UpdatePaymentResponse.class);

        return response;
    }

    @Override
    public void processSalePayment(CreateSalePaymentRequest request) {
        rules.checkIfPaymentIsValid(request);
        Payment payment = paymentRepository.findByCardNumber(request.getCardNumber());
        GetProductResponse product = productService.getById(request.getProductId());

        rules.checkIfBalanceEnough(payment.getBalance(), product.getPrice());
        posService.pay();

        payment.setBalance(payment.getBalance() - request.getPrice());
        paymentRepository.save(payment);
    }

    @Override
    public void delete(int id) {
        rules.checkIfPaymentExists(id);

        paymentRepository.deleteById(id);
    }
}
