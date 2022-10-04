package App.Repository;

import App.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    // For testing
    @Query("from Transactions")
    public List<Transactions> getAllTransactions();

    @Query("from Transactions where user_id = :user_id")
    public List<Transactions> getAllTransactionsByUserId(@Param("user_id")int user_id);

    @Query("from Transactions where user_id = :user_id and transaction_id = :transaction_id")
    public Transactions getTransactionFromUserById(@Param("user_id")int user_id, @Param("transaction_id")int transaction_id);

    @Query("from Transactions where user_id = :user_id and date = :date")
    public List<Transactions> getTransactionsFromUserByIdByDate(@Param("user_id")int user_id, @Param("date")LocalDate date);
}
