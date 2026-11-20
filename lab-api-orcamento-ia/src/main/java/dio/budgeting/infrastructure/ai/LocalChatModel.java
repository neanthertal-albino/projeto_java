package dio.budgeting.infrastructure.ai;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.tool.ToolCallingChatOptions;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * FAKE do modelo de linguagem: implementa ChatModel, a mesma interface real.
 *
 * Ele so reconhece duas intencoes e chama a ferramenta certa. Num modelo de
 * verdade, essa "decisao" seria feita pela OpenAI/Google/etc. — o resto do
 * projeto continua exatamente o mesmo.
 */
@Component
public class LocalChatModel implements ChatModel {

    private static final Pattern VALOR = Pattern.compile("(\\d+)\\s*reais", Pattern.CASE_INSENSITIVE);
    private static final Pattern DESCRICAO = Pattern.compile("(?:em|no|na)\\s+(.+)", Pattern.CASE_INSENSITIVE);

    @Override
    public ChatResponse call(Prompt prompt) {
        String texto = prompt.getInstructions().stream()
                .filter(m -> m instanceof UserMessage)
                .map(m -> ((UserMessage) m).getText())
                .reduce("", (a, b) -> a + " " + b)
                .trim();

        String resposta;
        if (texto.matches("(?i).*(gastei|paguei|comprei).*")) {
            resposta = registrarGasto(texto, prompt);
        } else if (texto.matches("(?i).*(quanto|listar|gastos).*")) {
            resposta = chamarFerramenta(prompt, "listTransactionsByCategory",
                    "{\"category\":\"OTHER\"}", "Consultei seus gastos.");
        } else {
            resposta = "Nao entendi o comando. Tente 'Gastei 60 reais em estacionamento'.";
        }

        return new ChatResponse(List.of(new Generation(new AssistantMessage(resposta))));
    }

    private String registrarGasto(String texto, Prompt prompt) {
        Matcher valor = VALOR.matcher(texto);
        Matcher descricao = DESCRICAO.matcher(texto);
        if (!valor.find() || !descricao.find()) {
            return "Nao consegui entender o valor e a descricao.";
        }

        long centavos = Long.parseLong(valor.group(1)) * 100;
        String nome = descricao.group(1).trim();
        String categoria = categoriaPara(nome);
        String argumentos = "{\"description\":\"" + nome + "\",\"amount\":" + centavos
                + ",\"category\":\"" + categoria + "\"}";

        return chamarFerramenta(prompt, "persistTransaction", argumentos,
                "Registrei " + centavos + " centavos em " + nome + ".");
    }

    private String categoriaPara(String descricao) {
        String nome = descricao.toLowerCase();
        if (nome.contains("mercado")) return "GROCERIES";
        if (nome.contains("farm")) return "PHARMA";
        if (nome.contains("estacion") || nome.contains("combust")) return "AUTO";
        return "OTHER";
    }

    private String chamarFerramenta(Prompt prompt, String nome, String argumentos, String fallback) {
        if (!(prompt.getOptions() instanceof ToolCallingChatOptions opcoes)) {
            return fallback + " (sem ferramentas disponiveis)";
        }
        for (ToolCallback ferramenta : opcoes.getToolCallbacks()) {
            if (ferramenta.getToolDefinition().name().equals(nome)) {
                return ferramenta.call(argumentos);
            }
        }
        return fallback + " (ferramenta " + nome + " nao encontrada)";
    }
}
