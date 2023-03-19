package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManager implements ProductService {

    ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        if (productRepository.getAll().size() == 0) throw new RuntimeException("No Product is found.");
        return productRepository.getAll();
    }

    @Override
    public Product getId(int id) {
        return productRepository.getId(id);
    }

    @Override
    public void add(Product product)  {
        if(product.getPrice() <= 0){
            throw new RuntimeException("Fiyat sıfırdan büyük olmalıdır.");
        }
        if(product.getQuantity() <= 0){
            throw new RuntimeException("Ürün miktarı sıfırdan büyük olmalıdır");
        }
        if (product.getDescription().length() <= 10 || product.getDescription().length() >= 50){
            throw  new RuntimeException("Açıklama alanı min 10 karakter max 50 karakter olmalıdır");
        }else {
            productRepository.add(product);
        }
    }

    @Override
    public void update(Product product)  {
        if(product.getPrice() < 0){
            throw new RuntimeException("Fiyat sıfırdan büyük olmalıdır.");
        }
        if(product.getQuantity() < 0){
            throw new RuntimeException("Ürün miktarı sıfırdan büyük olmalıdır");
        }
        if (product.getDescription().length() <= 10 || product.getDescription().length() >= 50){
            throw  new RuntimeException("Açıklama alanı min 10 karakter max 50 karakter olmalıdır");
        }else {
            productRepository.update(product);
        }
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }
}
