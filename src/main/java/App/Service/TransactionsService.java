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

    /**
     * Calls the repository method to get all transactions from the database. For testing purposes.
     * @return a list of all transactions
     */
    public List<Transactions> getAllTransactions() {
        return tr.getAllTransactions();
    }

    /**
     * Calls the repository method to add a transaction to the database
     * @param t transaction to be added
     * @return the transaction that was added if successful and null if failed
     */
    public Transactions addTransaction(Transactions t) {
        return tr.save(t);
    }

    /**
     * Calls the repository method to get a single transaction from the database
     * @param user_id
     * @param transaction_id
     * @return a single transaction from a specified user id and transaction id
     */
    public Transactions getTransactionFromUserById(int user_id, int transaction_id) {
        return tr.getTransactionFromUserById(user_id, transaction_id);
    }

    /**
     * Calls the repository method to get all transactions from a specified user id from the database
     * @param id of user
     * @return a list of transactions with id matching input id
     */
    public List<Transactions> getAllTransactionsFromUserById(int id) {
        return tr.getAllTransactionsByUserId(id);
    }

    /**
     * Calls the repository method to get all transactions on a specified date
     * @param date FORMAT: MMDDYY
     * @return a list of transactions with date matching input date
     */
    public List<Transactions> getTransactionsByDate(LocalDate date) {
        return tr.getTransactionsByDate(date);
    }
}
