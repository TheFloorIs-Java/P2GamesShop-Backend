package App.Repository;

import App.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    @Query("from Transactions where user_id = :user_id")
    public List<Transactions> getAllTransactionsByUser();

    @Query("from Transactions where user_id = :user_id and transaction_id = :transaction_id")
    public Transactions getTransactionFromUserById();
}
