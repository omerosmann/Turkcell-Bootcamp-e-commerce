package e.commerce.ecommerce.business.dto.responses.gets.ship;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllShipsResponse {
    private int id;
    private String shipNo;
}