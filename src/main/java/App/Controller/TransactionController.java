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

    // Add a transaction
    @PostMapping("/{user_id}/transactions")
    public Transactions addTransaction(@RequestBody Transactions t) {
        return ts.addTransaction(t);
    }

    // Get all Transactions for a specific date
    @GetMapping("/transactions/{date}")
    public List<Transactions> getTransactionsByDate(@PathVariable LocalDate date) {
        return ts.getTransactionsByDate(date);
    }

    // Testing endpoints
    @GetMapping("")
    public String defaultResponse() {return "Response from backend.";}

    public List<Transactions> getAllTransactions() {
        return ts.getAllTransactions();
    }


}
