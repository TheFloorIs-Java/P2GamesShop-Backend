package App.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int transaction_id;     // Primary key

    @Column
    int user_id;            // Foreign key

    @Column
    double total_price;

    // TODO: Test in Postman
    @OneToMany(mappedBy = "transactions")
    @JsonManagedReference
    @Column
    List<Product> products;
}
