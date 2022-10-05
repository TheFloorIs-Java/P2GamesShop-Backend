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
