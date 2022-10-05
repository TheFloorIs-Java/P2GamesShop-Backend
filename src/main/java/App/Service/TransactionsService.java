package App.Service;

import App.Model.Transactions;
import App.Repository.TransactionsRepository;
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

    public Transactions addTransaction(Transactions t) {
        return tr.save(t);
    }

    public Transactions getTransactionFromUserById(int user_id, int transaction_id) {
        return tr.getTransactionFromUserById(user_id, transaction_id);
    }

    // Get all transactions from a user on a specific date
    public List<Transactions> getTransactionsByDate(LocalDate date) {
        return tr.getTransactionsByDate(date);
    }
}
