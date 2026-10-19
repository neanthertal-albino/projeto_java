// PIX — implementação de FormaPagamento.
// Este arquivo vem PRONTO: ele é o seu exemplo / gabarito de modelo.
// Repare que "implements" promete o contrato: pagar() e getNome().
//
// A chave Pix é o ESTADO, e o estado mora na classe (a interface não tem campos).

public class Pix implements FormaPagamento {

    private String chave; // pode ser e-mail, telefone ou chave aleatória

    public Pix(String chave) {
        this.chave = chave;
    }

    // Quem implementa decide COMO o pagamento acontece.
    // O @Override é opcional em interfaces, mas é boa prática avisar
    // que este método cumpre a promessa do contrato.
    @Override
    public void pagar(double valor) {
        System.out.printf("Pagamento de R$ %.2f via Pix (chave: %s). Sem taxa!%n", valor, chave);
    }

    @Override
    public String getNome() {
        return "Pix";
    }
}
