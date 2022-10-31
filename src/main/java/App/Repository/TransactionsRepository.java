package App.Repository;

import App.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    // For testing with Postman - gets all transactions
    @Query("from Transactions")
    public List<Transactions> getAllTransactions();

    // All transaction from a user
    @Query("from Transactions where user_id = :user_id")
    public List<Transactions> getAllTransactionsByUserId(@Param("user_id")int user_id);

    // Single transaction from a user
    @Query("from Transactions where user_id = :user_id and transaction_id = :transaction_id")
    public Transactions getTransactionFromUserById(@Param("user_id")int user_id, @Param("transaction_id")int transaction_id);

    // All transactions from all users on specific date
    @Query("from Transactions where date = :date")
    public List<Transactions> getTransactionsByDate(@Param("date")LocalDate date);
}
//This repository automatically generates many of the queries that may need to be called by the API
//such as "select all from table," specific queries can also be constructed here.
