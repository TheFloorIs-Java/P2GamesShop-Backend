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

    // Get all Transactions by a specific user
    @GetMapping("/{user_id}/transactions")
    public List<Transactions> getAllTransactionsByUserId(@PathVariable int user_id) {
        return ts.getAllTransactionsFromUserById(user_id);
    }
    //Service call to get all transactions based on the user ID passed in by the frontend.

    // Add a transaction
    @PostMapping("/{user_id}/transactions")
    public Transactions addTransaction(@RequestBody Transactions t) {
        return ts.addTransaction(t);
    }
    //Service call to add a new transaction to the database.

    // Get all Transactions for a specific date
    @GetMapping("/transactions/{date}")
    public List<Transactions> getTransactionsByDate(@PathVariable String date) {
        return ts.getTransactionsByDate(LocalDate.parse(date));
    }
    //Service call to get all transactions based on the date passed in by the frontend.

    // Testing endpoints
    @GetMapping("")
    public String defaultResponse() {return "Response from backend.";}
    //A default endpoint to check if the API is currently running.

    @GetMapping("/transactions")
    public List<Transactions> getAllTransactions() {
        return ts.getAllTransactions();
    }
    //Service call to get all transactions.


}
