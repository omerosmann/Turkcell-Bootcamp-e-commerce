package kodlama.io.ecommerce.business.dto.responses.update;

import kodlama.io.ecommerce.entities.enums.StockStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePhoneResponse {
    private long id;
    private String name;
    private String color;
    private long  internalMemory;
    private long quantity;
    private double price;
    private String description;
    private StockStatus stockStatus;
    private long modelId;

}
