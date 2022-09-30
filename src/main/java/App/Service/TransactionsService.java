package App.Service;

import App.Model.Transactions;
import App.Repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TransactionsService {
    TransactionsRepository tr;

    @Autowired
    public TransactionsService(TransactionsRepository tr) {
        this.tr = tr;
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
        // User u = UserRepository.findById(id).get();

        // Transactions t = ts.getTransactionFromUserById();
        return null;
    }
}
