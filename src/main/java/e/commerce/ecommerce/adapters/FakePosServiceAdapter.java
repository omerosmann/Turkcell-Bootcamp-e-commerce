package e.commerce.ecommerce.adapters;

import e.commerce.ecommerce.business.abstracts.PosService;
import org.springframework.stereotype.Service;

@Service
public class FakePosServiceAdapter implements PosService {
    @Override
    public void pay() {
        boolean isPaymentSuccessful = true;
        if(!isPaymentSuccessful) throw new RuntimeException("Ödeme Reddedildié");
    }
}
