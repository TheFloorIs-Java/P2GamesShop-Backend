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

    /**
     * Get all Products
     * @return a list of all products in the database
     */
    @GetMapping("products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    /**
     * Get a Product by product ID
     * @param id an integer representing the id of a product in the database
     * @return a single product based on the ID input
     */
    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }

    /**
     * Add a Product to the database
     * @param p product to be added
     */
    @PostMapping("products")
    public void addProduct(@RequestBody Product p){
        productService.addProduct(p);
    }

    /**
     * Update a product that already exists in the database
     * @param p product that contains the new information to be added to the product
     * @param id an integer representing the ID of the product to be updated
     */
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

    /**
     * Delete a Product from the database
     * @param id an integer representing the ID of the product to be deleted
     */
    @DeleteMapping("products/delete/{id}")
    public void deleteProduct(@PathVariable("id") int id) {productService.deleteProduct(id);}
    //Service call to delete a product based on the product ID passed in by the frontend.


}
