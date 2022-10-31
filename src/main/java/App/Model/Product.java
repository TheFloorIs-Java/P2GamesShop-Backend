package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//These annotations auto generate certain constructors and methods on runtime (like getters and setters)
//as well as declaring this model as a table in the connected database.
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public int product_id;
    @Column
    public String product_name;
    @Column
    public int release_date;
    @Column
    public double price;
    @Column
    public int quantity;
    @Column
    public String product_img;
}
//This is the model for Products that defines the traits that products have in the database. Each of these values is
//connected to a column in the database.
