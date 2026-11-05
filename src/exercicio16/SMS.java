// SMS — implementação de ServicoMensagem.
// Este arquivo vem PRONTO: é o seu gabarito de modelo pro resto.
// Repare que o ESTADO (o número de telefone) mora na classe, não na interface.

public class SMS implements ServicoMensagem {

    private String numero; // para qual número vai o SMS

    public SMS(String numero) {
        this.numero = numero;
    }

    // O contrato promete: receber a mensagem e fazer algo com ela.
    @Override
    public void enviar(String mensagem) {
        System.out.printf("[SMS -> %s] %s%n", numero, mensagem);
    }

    @Override
    public String getNome() {
        return "SMS";
    }
}
