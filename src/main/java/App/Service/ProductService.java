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
    public List<Product> getAllProducts(){
        return pr.findAll();
    }
    //Repository call to get all products.

    public Product getProduct(int id){
        return pr.getProductByID(id);
    }
    //Repository call to get a product based on the product ID passed in by the frontend.

    public void addProduct(Product g){ pr.save(g); }
    //Repository call to add a product passed in by the frontend.

    public void updateProduct(Product product){ pr.save(product); }
    //Repository call to update a product based on the information passed in by the frontend.

    public void deleteProduct(int id){ pr.deleteById(id); }
}
//Repository call to delete a product based on the product ID passed in by the frontend.
