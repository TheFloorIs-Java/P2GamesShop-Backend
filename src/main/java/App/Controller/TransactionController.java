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

    @GetMapping("/{user}/transactions")
    public List<Transactions> getAllTransactionsByUser() {
        return null;
    }

    @PostMapping("/{user}/transactions")
    public Transactions addTransaction(@RequestBody Transactions t) {
        return ts.addTransaction(t);
    }

    // Transaction for a specific date
    @GetMapping("/transactions/{date}")
    public List<Transactions> getTransactionsByDate(@PathVariable LocalDate date) {
        return ts.getTransactionsByDate(date);
    }

    @GetMapping("")
    public String defaultResponse() {return "Response from backend.";}
}
