package dio.budgeting.domain;

import java.util.UUID;

/**
 * Regra de negocio da transacao.
 *
 * AQUI ESTA A SUA MELHORIA (lacunas para completar):
 * o projeto base aceita qualquer coisa. Sua versao vai barrar dados invalidos
 * ANTES de chegar no banco — tanto pela API REST quanto pelo comando de voz.
 */
public class Transaction {

    private String id;
    private final String description;
    private final long amount; // valor em CENTAVOS (60 reais = 6000)
    private final Category category;

    public Transaction(String description, long amount, Category category) {
        // Validacao: a regra fica no dominio e vale para REST e para a voz.
        if (description == null || description.isBlank()) {
            throw new InvalidTransactionException("descricao obrigatoria");
        }
        if (amount <= 0) {
            throw new InvalidTransactionException("valor deve ser maior que zero");
        }
        if (category == null) {
            throw new InvalidTransactionException("categoria obrigatoria");
        }

        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    /** Usado pela camada de persistencia para devolver o mesmo id do banco. */
    public static Transaction restore(String id, String description, long amount, Category category) {
        Transaction transaction = new Transaction(description, amount, category);
        transaction.id = id;
        return transaction;
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
