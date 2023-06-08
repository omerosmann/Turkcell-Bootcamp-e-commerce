package e.commerce.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "ships")
public class Ship {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String shipNo;

}
