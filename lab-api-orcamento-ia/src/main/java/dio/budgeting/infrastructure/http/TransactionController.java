package dio.budgeting.infrastructure.http;

import dio.budgeting.application.ListTransactionsByCategoryUseCase;
import dio.budgeting.application.PersistTransactionUseCase;
import dio.budgeting.domain.Category;
import dio.budgeting.domain.Transaction;
import dio.budgeting.infrastructure.http.dto.NewTransactionRequest;
import dio.budgeting.infrastructure.http.dto.TransactionResponse;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final PersistTransactionUseCase persistTransaction;
    private final ListTransactionsByCategoryUseCase listTransactions;

    public TransactionController(PersistTransactionUseCase persistTransaction,
                                 ListTransactionsByCategoryUseCase listTransactions) {
        this.persistTransaction = persistTransaction;
        this.listTransactions = listTransactions;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse criar(@RequestBody NewTransactionRequest request) {
        Transaction transaction = persistTransaction.execute(
                request.description(), request.amount(), request.category());
        return TransactionResponse.from(transaction);
    }

    @GetMapping("/{category}")
    public List<TransactionResponse> listar(@PathVariable Category category) {
        return listTransactions.execute(category).stream()
                .map(TransactionResponse::from)
                .toList();
    }
}
