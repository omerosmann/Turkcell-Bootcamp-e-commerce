package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
