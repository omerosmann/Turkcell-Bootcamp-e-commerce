package e.commerce.ecommerce.business.dto.responses.gets.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryResponse {
    private int id;
    private String name;
}