// ATENDENTE: herda de Usuario. NUNCA é administrador (false).
// Guarda o valor em caixa e tem os métodos ligados ao caixa.

public class Atendente extends Usuario {

    // Campo exclusivo do atendente. double nasce valendo 0.0 automaticamente.
    private double valorCaixa;

    public Atendente(String nome, String email, String senha) {
        // COMPLETAR: chame super(...) com administrador = false
        super(nome, email, senha, false);
    }

    public double getValorCaixa() {
        return valorCaixa;
    }

    public void receberPagamento(double valor) {
        // COMPLETAR: some o valor recebido ao caixa
        // e mostre o total atual (ex.: "Pagamento recebido! Caixa: R$ " + ...)
        valorCaixa += valor;
        System.out.printf("Pagamento recebido! Caixa: R$ %s\n", valorCaixa);
    }

    public void fecharCaixa() {
        // COMPLETAR: mostre o total do caixa e depois zere o valor em caixa
        System.out.printf("Total do caixa: %s\n", valorCaixa);
        valorCaixa = 0;
    }
}
