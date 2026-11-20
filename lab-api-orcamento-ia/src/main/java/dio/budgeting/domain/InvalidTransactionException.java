package dio.budgeting.domain;

public class InvalidTransactionException extends IllegalArgumentException {
    public InvalidTransactionException(String message) {
        super(message);
    }
}
