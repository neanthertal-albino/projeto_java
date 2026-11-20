package dio.budgeting.application;

import dio.budgeting.domain.Category;
import dio.budgeting.domain.Transaction;
import dio.budgeting.domain.TransactionRepository;

import org.springframework.stereotype.Service;

/** Caso de uso chamado tanto pelo controller REST quanto pela ferramenta da IA. */
@Service
public class PersistTransactionUseCase {

    private final TransactionRepository repository;

    public PersistTransactionUseCase(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction execute(String description, long amount, Category category) {
        // A regra de validacao fica dentro de new Transaction(...).
        // Ela vale aqui, na voz e em qualquer outro caminho que usar isto.
        Transaction transaction = new Transaction(description, amount, category);
        return repository.save(transaction);
    }
}
