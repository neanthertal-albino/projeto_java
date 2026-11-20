package dio.budgeting.application;

import dio.budgeting.domain.Category;
import dio.budgeting.domain.Transaction;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

/**
 * A ponte entre a IA e o mundo real.
 *
 * O modelo NAO grava nada no banco: ele so escolhe qual destas ferramentas
 * chamar. A ferramenta, por sua vez, chama o MESMO caso de uso usado pelo REST.
 */
@Component
public class BudgetTools {

    private final PersistTransactionUseCase persistTransaction;
    private final ListTransactionsByCategoryUseCase listTransactions;

    public BudgetTools(PersistTransactionUseCase persistTransaction,
                       ListTransactionsByCategoryUseCase listTransactions) {
        this.persistTransaction = persistTransaction;
        this.listTransactions = listTransactions;
    }

    @Tool(name = "persistTransaction",
          description = "Registra um gasto. valor em CENTAVOS: R$ 60,00 = 6000.")
    public String persistTransaction(
            @ToolParam(description = "Descricao do gasto") String description,
            @ToolParam(description = "Valor em centavos") long amount,
            @ToolParam(description = "Categoria: GROCERIES, PHARMA, AUTO ou OTHER") Category category) {
        Transaction saved = persistTransaction.execute(description, amount, category);
        return "Registrado: " + saved.getDescription() + " (" + saved.getAmount() + " centavos)";
    }

    @Tool(name = "listTransactionsByCategory",
          description = "Lista os gastos de uma categoria.")
    public String listTransactionsByCategory(
            @ToolParam(description = "Categoria: GROCERIES, PHARMA, AUTO ou OTHER") Category category) {
        List<Transaction> transactions = listTransactions.execute(category);
        return "Foram encontrados " + transactions.size() + " gasto(s) em " + category + ".";
    }
}
