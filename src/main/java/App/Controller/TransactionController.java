package App.Controller;

import App.Model.Transaction;
import App.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TransactionController {
    TransactionService ts;

    @Autowired
    public TransactionController(TransactionService ts) {
        this.ts = ts;
    }

    @GetMapping("/{user}/transactions")
    public List<Transaction> getAllTransactionsByUser() {
        return null;
    }

    @PostMapping("/{user}/transactions")
    public Transaction addTransaction(@RequestBody Transaction t) {
        return ts.addTransaction(t);
    }

    // Transaction for a specific date

}
