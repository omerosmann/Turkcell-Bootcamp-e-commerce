package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {
}
