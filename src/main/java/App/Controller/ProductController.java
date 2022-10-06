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

    @PutMapping("products/update/{id}")
    public void updateProduct(@RequestBody Product p, @PathVariable("id") int id) {
        Product newProduct = productService.getProduct(id);
        if (newProduct != null) {
            newProduct.setProduct_name(p.getProduct_name());
            newProduct.setRelease_date(p.getRelease_date());
            newProduct.setPrice(p.getPrice());
            newProduct.setQuantity(p.getQuantity());
            newProduct.setProduct_img(p.getProduct_img());
            productService.updateProduct(newProduct);
            }
    }

    @DeleteMapping("products/delete/{id}")
    public void deleteProduct(@PathVariable("id") int id) {productService.deleteProduct(id);}


}
