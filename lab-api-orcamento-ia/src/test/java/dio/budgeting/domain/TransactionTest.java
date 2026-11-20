package dio.budgeting.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * ESTES TESTES ESTAO VERMELHOS DE PROPOSITO.
 * Complete as tres lacunas de Transaction.java para eles ficarem verdes.
 */
class TransactionTest {

    @Test
    void aceitaTransacaoValida() {
        assertDoesNotThrow(() -> new Transaction("Estacionamento", 6000, Category.AUTO));
    }

    @Test
    void recusaDescricaoVazia() {
        assertThrows(InvalidTransactionException.class,
                () -> new Transaction("   ", 6000, Category.AUTO));
    }

    @Test
    void recusaValorZeroOuNegativo() {
        assertThrows(InvalidTransactionException.class,
                () -> new Transaction("Mercado", 0, Category.GROCERIES));
        assertThrows(InvalidTransactionException.class,
                () -> new Transaction("Mercado", -1, Category.GROCERIES));
    }

    @Test
    void recusaCategoriaNula() {
        assertThrows(InvalidTransactionException.class,
                () -> new Transaction("Mercado", 1000, null));
    }
}
