package dio.budgeting.infrastructure.ai;

import dio.budgeting.application.BudgetTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssistantConfig {

    @Bean
    public ChatClient chatClient(ChatModel chatModel, BudgetTools tools) {
        return ChatClient.builder(chatModel)
                .defaultSystem("""
                        Voce e um assistente de orcamento em portugues.
                        Responda em no maximo duas frases, sem markdown.
                        Para registrar gastos use a ferramenta persistTransaction.
                        Para consultas use listTransactionsByCategory.
                        """)
                .defaultTools(tools)
                .build();
    }
}
