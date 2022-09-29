package App.Service;

import App.Model.Transaction;
import App.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionService {
    TransactionRepository tr;

    @Autowired
    public TransactionService(TransactionRepository tr) {
        this.tr = tr;
    }

    public Transaction addTransaction(Transaction t) {
        return tr.save(t);
    }

    public Transaction getTransactionFromUserById(int id) {
        // Get User
        // User u = UserRepository.findById(id).get();

        // Transaction t = getTransactionFromUserById();
        return null;
    }
}
