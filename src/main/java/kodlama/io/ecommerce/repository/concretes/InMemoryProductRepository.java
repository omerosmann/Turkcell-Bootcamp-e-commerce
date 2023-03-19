package kodlama.io.ecommerce.repository.concretes;

import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    List<Product> products;

    public InMemoryProductRepository(){
        products = new ArrayList<Product>();
        products.add(new Product(1,"HP",5,30000,"16GB Ram / 1TB SSD / Renk : Siyah "));
        products.add(new Product(2,"MONSTER",15,40000,"32GB Ram / 1TB SSD / Renk : Gümüş"));
        products.add(new Product(3,"ASUS",5,12000,"4GB Ram / 256GB SSD / Renk : Mavi"));
        products.add(new Product(4,"LENOVO",20,20000,"8GB Ram / 512GB SSD / Renk : Siyah "));


    }

    @Override
    public Product getId(int id) {
        for (Product product : products) {
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void add(Product product) {
            products.add(product);
    }

    @Override
    public void delete(int id) {
        for (Product product : products) {
            if(product.getId() == id){
                products.remove(product);
            }
        }
    }

    @Override
    public void update(Product product) {
        for (Product product1 : products) {
            if(product.getId() == product1.getId()){
                product1.setId(product.getId());
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setQuantity(product.getQuantity());
                product1.setDescription(product.getDescription());
            }
        }
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
