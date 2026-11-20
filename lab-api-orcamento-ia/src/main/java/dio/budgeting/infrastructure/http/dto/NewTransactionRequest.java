package dio.budgeting.infrastructure.http.dto;

import dio.budgeting.domain.Category;

public record NewTransactionRequest(String description, long amount, Category category) {
}
