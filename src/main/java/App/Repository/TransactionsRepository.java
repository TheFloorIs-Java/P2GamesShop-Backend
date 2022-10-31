package App.Repository;

import App.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    /**
     * Queries the transactions table for all transactions - for testing purposes
     * @return all transactions from the table
     */
    @Query("from Transactions")
    public List<Transactions> getAllTransactions();

    /**
     * Queries the transactions table for all transactions made by a user
     * @param user_id
     * @return a list of transactions that match the input id
     */
    @Query("from Transactions where user_id = :user_id")
    public List<Transactions> getAllTransactionsByUserId(@Param("user_id")int user_id);

    /**
     * Queries the transaction table for a single transaction from a user
     * @param user_id
     * @param transaction_id
     * @return a single transaction that match the input user id and transaction id
     */
    @Query("from Transactions where user_id = :user_id and transaction_id = :transaction_id")
    public Transactions getTransactionFromUserById(@Param("user_id")int user_id, @Param("transaction_id")int transaction_id);

    /**
     * Queries the transactions table for a list transactions made on a certain date
     * @param date
     * @return a list of transactions that match the input date
     */
    @Query("from Transactions where date = :date")
    public List<Transactions> getTransactionsByDate(@Param("date")LocalDate date);
}
//This repository automatically generates many of the queries that may need to be called by the API
//such as "select all from table," specific queries can also be constructed here.
