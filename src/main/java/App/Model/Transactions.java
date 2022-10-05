package App.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    double total_price;

    LocalDate date;

    @Column
    List<Product> products;

    // Constructor that instantiates a new ArrayList() of products
    public Transactions(int transaction_id, int user_id, double total_price, LocalDate date) {
        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.total_price = total_price;
        this.date = date;
        this.products = new ArrayList<>();
    }

    // Constructor that sets the current list of products in transactions to the given list
    public Transactions(int transaction_id, int user_id, double total_price, LocalDate date, List<Product> products) {
        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.total_price = total_price;
        this.date = date;
        this.products = products;
    }
}
