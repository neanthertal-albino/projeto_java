package dio.budgeting.infrastructure.persistence;

import dio.budgeting.domain.Category;
import dio.budgeting.domain.Transaction;
import dio.budgeting.domain.TransactionRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private final TransactionJpaRepository jpa;

    public TransactionRepositoryImpl(TransactionJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity entity = jpa.save(new TransactionEntity(transaction));
        return entity.toDomain();
    }

    @Override
    public List<Transaction> findByCategory(Category category) {
        return jpa.findByCategory(category).stream()
                .map(TransactionEntity::toDomain)
                .toList();
    }
}

interface TransactionJpaRepository extends JpaRepository<TransactionEntity, String> {
    List<TransactionEntity> findByCategory(Category category);
}
