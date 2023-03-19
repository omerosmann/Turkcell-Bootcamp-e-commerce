package kodlama.io.ecommerce;

import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.concretes.InMemoryProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}
