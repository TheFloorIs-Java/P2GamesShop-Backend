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

<<<<<<< HEAD
        Transactions t = tr.getTransactionFromUserById(u.getId(), transaction_id);
        return t;
    }

    // Get all transactions from a user on a specific date
    public List<Transactions> getTransactionsByDate(LocalDate date) {
        return tr.getTransactionsByDate(date);
=======
        // Transaction t = getTransactionFromUserById();
        return null;
>>>>>>> f2431097cbef918d9141b68528c5d83e542baa4e
    }
}
