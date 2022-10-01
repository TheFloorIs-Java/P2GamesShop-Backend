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

    // Transaction for a specific date

    @GetMapping("")
    public String defaultResponse() {return "Response from backend.";}
}
