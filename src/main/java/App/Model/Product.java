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
    /**
     * The primary key for the table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public int product_id;
    /**
     * The name of the product
     */
    @Column
    public String product_name;
    /**
     * The original release date of the product
     */
    @Column
    public int release_date;
    /**
     * The current price of the product at our store
     */
    @Column
    public double price;
    /**
     * The quantity of the product currently available for purchase
     */
    @Column
    public int quantity;
    /**
     * A string to input the URL for an image of the product
     */
    @Column
    public String product_img;
}
//This is the model for Products that defines the traits that products have in the database. Each of these values is
//connected to a column in the database.
