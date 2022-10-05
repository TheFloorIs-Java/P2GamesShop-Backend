package App.Repository;

import App.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    @Query("from Transactions where user_id = :user_id")
<<<<<<< HEAD
    public List<Transactions> getAllTransactionsByUserId(@Param("user_id")int user_id);

    @Query("from Transactions where user_id = :user_id and transaction_id = :transaction_id")
    public Transactions getTransactionFromUserById(@Param("user_id")int user_id, @Param("transaction_id")int transaction_id);

    @Query("from Transactions where date = :date")
    public List<Transactions> getTransactionsByDate(@Param("date")LocalDate date);
=======
    public List<Transactions> getAllTransactionsByUser();
>>>>>>> f2431097cbef918d9141b68528c5d83e542baa4e
}
