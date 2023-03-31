package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
