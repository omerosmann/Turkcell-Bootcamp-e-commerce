package e.commerce.ecommerce.repository;

import e.commerce.ecommerce.entities.Product;
import e.commerce.ecommerce.entities.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{ List<Product> findAllByStateIsNot(State state); }