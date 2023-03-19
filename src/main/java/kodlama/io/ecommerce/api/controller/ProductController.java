package kodlama.io.ecommerce.api.controller;


import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/getId")
    public Product getId(@PathVariable int id) {
        return productService.getId(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Product product){
        productService.add(product);
    }

    @PutMapping("/update")
    public void update(@RequestBody Product product) throws Exception {
        productService.update(product);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) throws Exception {
        productService.delete(id);
    }



}
