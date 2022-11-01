package App.Controller;

import App.Model.Transactions;
import App.Service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class TransactionController {
    TransactionsService ts;

    @Autowired
    public TransactionController(TransactionsService ts) {
        this.ts = ts;
    }

    /**
     * Get all Transactions by a specific user
     * @param user_id an integer representing the id of the user in the database
     * @return a list of transactions made by a certain user
     */
    @GetMapping("/{user_id}/transactions")
    public List<Transactions> getAllTransactionsByUserId(@PathVariable int user_id) {
        return ts.getAllTransactionsFromUserById(user_id);
    }

    /**
     * Add a transaction to the database
     * @param t transaction to be added
     * @return the transaction that was added if successful otherwise null
     */
    @PostMapping("/{user_id}/transactions")
    public Transactions addTransaction(@RequestBody Transactions t) {
        return ts.addTransaction(t);
    }
    //Service call to add a new transaction to the database.

    /**
     * Get all Transactions for a specific date
     * @param date A string representation of the date - FORMAT: MMDDYY
     * @return a list of transactions on a certain date
     */
    @GetMapping("/transactions/{date}")
    public List<Transactions> getTransactionsByDate(@PathVariable String date) {
        return ts.getTransactionsByDate(LocalDate.parse(date));
    }

    // Testing endpoints

    /**
     * For testing purposes
     * @return A default response
     */
    @GetMapping("")
    public String defaultResponse() {return "Response from backend.";}

    /**
     * Gets all transactions from all users
     * @return A list of transaction from all users
     */
    @GetMapping("/transactions")
    public List<Transactions> getAllTransactions() {
        return ts.getAllTransactions();
    }
}
