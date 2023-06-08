package e.commerce.ecommerce.entities;

import e.commerce.ecommerce.entities.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "products")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int quantity;
    private double price;
    private String description;

    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne
    private Category category; // category_id


    @OneToMany(mappedBy = "product")
    private List<Sale> sales;

}