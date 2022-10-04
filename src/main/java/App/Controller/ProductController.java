package App.Controller;

import App.Model.Product;
import App.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {
    ProductService productService;
    @Autowired
    public ProductController(ProductService ps){
        this.productService = ps;
    }

    @GetMapping("products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }

    @PostMapping("products")
    public void addProduct(@RequestBody Product p){
        productService.addProduct(p);
    }

    @PutMapping("products")
    public void updateProduct(@RequestBody Product product) {productService.updateProduct(product);}

    @DeleteMapping("products")
    public void deleteProduct(@RequestBody Product p) {productService.deleteProduct(p);}


    //test
    @GetMapping(value = "hello")
    public String sayHello(){return "Hello API!";}
    //test
}
