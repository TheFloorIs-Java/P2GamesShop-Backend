package App.Repository;

import App.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("from Product where id=:id")
    public Product getProductByID(@Param("id") int id);
}
//This repository automatically generates many of the queries that may need to be called by the API
//such as "select all from table," specific queries can also be constructed here.