package kodlama.io.ecommerce.business.abstracts;

import kodlama.io.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getId(int id);

    void add(Product product);

    void update(Product product);

    void delete(int id);
}
