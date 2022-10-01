package App.Service;

import App.Model.Transactions;
import App.Model.Users;
import App.Repository.TransactionsRepository;
import App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    // TODO: Determine whether to use user_id or username
    public Transactions getTransactionFromUserById(String user, int id) {
        // Get User
        Users u = ur.findById(id).get();

        Transactions t = tr.getTransactionFromUserById(u.getId());
        return t;
    }
}
