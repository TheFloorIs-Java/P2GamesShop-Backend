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
    //Service call to get all products.

    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }
    //Service call to get a specific product based on the product ID passed in by the frontend.

    @PostMapping("products")
    public void addProduct(@RequestBody Product p){
        productService.addProduct(p);
    }
    //Service call to add the product passed in by the frontend to the database.

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
    //Code to Update a product. It first checks to see if the product ID passed in exists
    // and if it does it will update that product with the other information passed in.

    @DeleteMapping("products/delete/{id}")
    public void deleteProduct(@PathVariable("id") int id) {productService.deleteProduct(id);}
    //Service call to delete a product based on the product ID passed in by the frontend.


}
