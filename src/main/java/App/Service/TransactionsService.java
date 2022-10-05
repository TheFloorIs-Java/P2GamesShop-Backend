package App.Service;

import App.Model.Transactions;
import App.Repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Transactions getTransactionFromUserById(int id) {
        // Get User
        // User u = UserRepository.findById(id).get();

        // Transaction t = getTransactionFromUserById();
        return null;
    }
}
