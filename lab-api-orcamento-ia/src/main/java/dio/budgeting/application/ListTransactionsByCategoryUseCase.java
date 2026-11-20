package dio.budgeting.application;

import dio.budgeting.domain.Category;
import dio.budgeting.domain.Transaction;
import dio.budgeting.domain.TransactionRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListTransactionsByCategoryUseCase {

    private final TransactionRepository repository;

    public ListTransactionsByCategoryUseCase(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> execute(Category category) {
        return repository.findByCategory(category);
    }
}
