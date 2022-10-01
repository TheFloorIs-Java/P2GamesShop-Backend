package App.Controller;

import App.Model.Transactions;
import App.Service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TransactionController {
    TransactionsService ts;

    @Autowired
    public TransactionController(TransactionsService ts) {
        this.ts = ts;
    }

    // Test endpoint
    @GetMapping("/transactions")
    public List<Transactions> getAllTransactions() {
        return ts.getAllTransactions();
    }

    // Username/user_id
    @GetMapping("/{user}/transactions")
    public List<Transactions> getAllTransactionsByUser() {
        return null;
    }

    // Username/user_id
    @PostMapping("/{user}/transactions")
    public Transactions addTransaction(@RequestBody Transactions t) {
        return ts.addTransaction(t);
    }

    // Specific transaction from a user by id
    // TODO: Determine whether to use user_id or username
    @GetMapping("/{user}/{transaction_id}")
    public Transactions getTransactionFromUserById(@PathVariable String user, @PathVariable int transaction_id) {
        return ts.getTransactionFromUserById(user, transaction_id);
    }

    // Transaction for a specific date

    @GetMapping("")
    public String defaultResponse() {return "Response from backend.";}
}
