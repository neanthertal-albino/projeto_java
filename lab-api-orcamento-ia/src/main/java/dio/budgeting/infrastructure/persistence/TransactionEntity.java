package dio.budgeting.infrastructure.persistence;

import dio.budgeting.domain.Category;
import dio.budgeting.domain.Transaction;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/** "Foto" do objeto de dominio para o banco. Fica só nesta camada. */
@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    private String id;
    private String description;
    private long amount;

    @Enumerated(EnumType.STRING)
    private Category category;

    public TransactionEntity() {
    }

    public TransactionEntity(Transaction transaction) {
        this.id = transaction.getId();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.category = transaction.getCategory();
    }

    public Transaction toDomain() {
        return Transaction.restore(id, description, amount, category);
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public long getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }
}
