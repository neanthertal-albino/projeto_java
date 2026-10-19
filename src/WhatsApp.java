// WHATSAPP — implementação de ServicoMensagem.
// Mesmo contrato, comportamento diferente: manda pelo zap.

public class WhatsApp implements ServicoMensagem {

    private String telefone; // para qual telefone vai a mensagem

    public WhatsApp(String telefone) {
        this.telefone = telefone;
    }
    
    // COMPLETAR: construtor com um parâmetro String chamado telefone

    @Override
    public void enviar(String mensagem) {
        // COMPLETAR: imprima algo no formato:
        // [WhatsApp -> (11) 99999-0000] <mensagem>
            System.out.printf("[WhatsApp -> %s] %s%n\n", telefone, mensagem);
        
    }

    @Override
    public String getNome() {
        return "WhatsApp"; // já pronto
    }
}
