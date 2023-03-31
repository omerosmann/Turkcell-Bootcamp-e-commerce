package kodlama.io.ecommerce.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.enums.StockStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String color;
    private long  internalMemory;
    private double price;
    private long quantity;
    private String description;
    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;
    @ManyToOne
    @JsonManagedReference
    private Model model;


}
