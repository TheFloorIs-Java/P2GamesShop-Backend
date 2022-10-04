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

    // Test endpoints ----------------------------------------------------------------
    @GetMapping("/transactions")
    public List<Transactions> getAllTransactions() {
        return ts.getAllTransactions();
    }

    @PostMapping("/transactions")
    public Transactions testAddTransaction(@RequestBody Transactions t) {
        return ts.addTransaction(t);
    }

    // -------------------------------------------------------------------------------

    // Get all transactions from a user
    @GetMapping("/{user_id}/transactions")
    public List<Transactions> getAllTransactionsByUser() {
        return ts.getAllTransactions();
    }

    // Add a transaction to a user
    @PostMapping("/{user_id}/transactions")
    public Transactions addTransaction(@RequestBody Transactions t) {
        return ts.addTransaction(t);
    }

    // Specific transaction from a user by id
    // TODO: Determine whether to use user_id or username
    @GetMapping("/{user_id}/{transaction_id}")
    public Transactions getTransactionFromUserById(@PathVariable int user_id, @PathVariable int transaction_id) {
        return ts.getTransactionFromUserById(user_id, transaction_id);
    }

    // Transaction for a specific date
    @GetMapping("/{user_id}/transactions/{date}")
    public List<Transactions> getTransactionsFromUserByIdByDate(@PathVariable int user_id, @PathVariable LocalDate date) {
        return ts.getTransactionsFromUserByIdByDate(user_id, date);
    }

    @GetMapping("")
    public String defaultResponse() {return "Response from backend.";}
}
