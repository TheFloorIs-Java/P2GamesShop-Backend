package App.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
//These annotations auto generate certain constructors and methods on runtime (like getters and setters)
//as well as declaring this model as a table in the connected database.
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int transaction_id;     // Primary key

    @Column
    int user_id;            // Foreign key

    @Column
    double total_price;

    @Column
    LocalDate date;

    @Column
    String products;
}
//This is the model for Transactions that defines the traits that transactions have in the database. Each of these values is
//connected to a column in the database.
