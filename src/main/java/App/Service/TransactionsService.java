package App.Service;

import App.Model.Transactions;
import App.Model.Users;
import App.Repository.TransactionsRepository;
import App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class TransactionsService {
    TransactionsRepository tr;
    UserRepository ur;

    @Autowired
    public TransactionsService(TransactionsRepository tr, UserRepository ur) {
        this.tr = tr;
        this.ur = ur;
    }

    // Method for testing endpoint
    public List<Transactions> getAllTransactions() {
        return tr.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Transactions addTransaction(Transactions t) {
        return tr.save(t);
    }

    public List<Transactions> getAllTransactionsFromUserById(int user_id) {
        return tr.getAllTransactionsByUserId(user_id);
    }

    // TODO: Determine whether to use user_id or username
    public Transactions getTransactionFromUserById(int user_id, int transaction_id) {
        // Get User
        Users u = ur.findById(user_id).get();

        Transactions t = tr.getTransactionFromUserById(u.getId(), transaction_id);
        return t;
    }

    // Get all transactions from a user on a specific date
    public List<Transactions> getTransactionsByDate(LocalDate date) {
        return tr.getTransactionsByDate(date);
    }
}
