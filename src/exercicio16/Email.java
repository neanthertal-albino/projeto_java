// E-mail — implementação de ServicoMensagem.
// Mesmo contrato do SMS, comportamento diferente: envia por e-mail.

public class Email implements ServicoMensagem {

    private String endereco; // para qual e-mail vai a mensagem

    // COMPLETAR: construtor com um parâmetro String chamado endereco
    // (lembre: construtor NÃO tem tipo de retorno e usa this.endereco = endereco;)

    public Email(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void enviar(String mensagem) {
        // COMPLETAR: imprima algo no formato:
        // [E-mail -> ana@email.com] <mensagem>
        // (copie o padrão do SMS.java e adapte — printf com %s)
        System.out.printf("[E-mail -> %s] %s%n", endereco, mensagem);
    }

    @Override
    public String getNome() {
        return "E-mail"; // já pronto
    }
}
