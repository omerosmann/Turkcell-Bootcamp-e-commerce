package kodlama.io.ecommerce.business.dto.requests.update;

import kodlama.io.ecommerce.entities.enums.StockStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePhoneRequest {
    private String name;
    private String color;
    private long  internalMemory;
    private long quantity;
    private double price;
    private String description;
    private StockStatus stockStatus;
    private long modelId;

}
