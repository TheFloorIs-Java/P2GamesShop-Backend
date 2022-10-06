package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
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
