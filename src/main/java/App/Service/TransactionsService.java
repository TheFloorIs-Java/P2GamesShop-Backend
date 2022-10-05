package App.Service;

import App.Model.Transactions;
import App.Repository.TransactionsRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TransactionsService {
    TransactionsRepository tr;

    @Autowired
    public TransactionsService(TransactionsRepository tr) {
        this.tr = tr;
    }

    // For testing with Postman
    public List<Transactions> getAllTransactions() {
        return tr.getAllTransactions();
    }

    public Transactions addTransaction(Transactions t) {
        return tr.save(t);
    }

    // Get a single transaction from a user
    public Transactions getTransactionFromUserById(int user_id, int transaction_id) {
        return tr.getTransactionFromUserById(user_id, transaction_id);
    }

    // Get all transaction from a user
    public List<Transactions> getAllTransactionsFromUserById(int id) {
        return tr.getAllTransactionsByUserId(id);
    }

    // Get all transactions from all users on a specific date
    public List<Transactions> getTransactionsByDate(LocalDate date) {
        return tr.getTransactionsByDate(date);
    }
}
