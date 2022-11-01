package App.Service;

import App.Model.Product;
import App.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    ProductRepository pr;
    @Autowired
    public ProductService(ProductRepository pr){
        this.pr = pr;
    }

    /**
     * Calls the repository method to get all products from the database
     * @return a list of all products
     */
    public List<Product> getAllProducts(){
        return pr.findAll();
    }

    /**
     * Calls the repository method to get a single product based on the input ID
     * @param id an integer representing the ID of a product in the database
     * @return a single product from the database
     */
    public Product getProduct(int id){
        return pr.getProductByID(id);
    }

    /**
     * Calls the repository method to add a product to the database
     * @param g product to be added
     */
    public void addProduct(Product g){ pr.save(g); }

    /**
     * Calls the repository method to update a product already in the database
     * @param product product with new information to save over the existing product
     */
    public void updateProduct(Product product){ pr.save(product); }

    /**
     * Calls the repository method to delete a product from the database
     * @param id an integer representing the ID of a product in the database
     */
    public void deleteProduct(int id){ pr.deleteById(id); }
}

