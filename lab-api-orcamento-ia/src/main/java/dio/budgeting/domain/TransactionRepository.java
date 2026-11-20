package dio.budgeting.domain;

import java.util.List;

/**
 * Contrato da camada de dominio. O dominio nao sabe se o dado vem de H2,
 * MySQL ou de um arquivo — ele so pede "salve" e "me devolva por categoria".
 */
public interface TransactionRepository {
    Transaction save(Transaction transaction);
    List<Transaction> findByCategory(Category category);
}
