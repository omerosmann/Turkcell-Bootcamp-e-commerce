package kodlama.io.ecommerce.repository.abstracts;

import kodlama.io.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductRepository {

    Product getId(int id);
    void add(Product product);
    void delete(int id);
    void update(Product product);
    List<Product> getAll();


}
