package dio.budgeting.infrastructure.http.dto;

import dio.budgeting.domain.Category;
import dio.budgeting.domain.Transaction;

public record TransactionResponse(String id, String description, long amount, Category category) {
    public static TransactionResponse from(Transaction transaction) {
        return new TransactionResponse(transaction.getId(), transaction.getDescription(),
                transaction.getAmount(), transaction.getCategory());
    }
}
