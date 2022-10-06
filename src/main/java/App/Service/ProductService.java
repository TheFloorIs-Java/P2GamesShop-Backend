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

    public Product getProduct(int id){
        return pr.getProductByID(id);
    }

    public void addProduct(Product g){ pr.save(g); }

    public void updateProduct(Product product){ pr.save(product); }

    public void deleteProduct(int id){ pr.deleteById(id); }
}
