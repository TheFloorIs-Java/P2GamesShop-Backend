package App.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
// @AllArgsConstructor
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
    LocalDate date;

    @Column
    double total_price;

//    TODO: Merge with rest of code and test
//    @OneToMany(mappedBy = "")
//    @JsonManagedReference
//    @Column
//    List<Product> products;

    public Transactions(int transaction_id, int user_id, LocalDate date, double total_price) {
        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.date = date;
        this.total_price = total_price;
    }
}
