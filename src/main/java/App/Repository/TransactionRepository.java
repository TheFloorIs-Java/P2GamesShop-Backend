package App.Repository;

import App.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("from Transaction where user_id = :user_id")
    public List<Transaction> getAllTransactionsByUser();
}
