public class ContaBancaria {
    private double saldo;
    private double LimiteChequeEspecial;
    private double ChequeEspecialUsado;

    public void ConsultarSaldo() {
        System.out.printf("Saldo: R$%.2f%n", saldo);
    }

    // Mostra o limite do cheque especial calculado no construtor
    public void ConsultarChequeEspecial() {
        System.out.printf("Limite do cheque especial: R$%.2f%n", LimiteChequeEspecial);
    }

    // Recebe um valor e soma ao saldo da conta
    public void Depositar(double valor) {
        saldo = saldo + valor;
    }

    // Construtor: SEM tipo de retorno (não pode ter "void" aqui)
    public ContaBancaria(double valorinicial) {
        saldo = valorinicial;

        if (valorinicial <= 500.00) {
            LimiteChequeEspecial = 50.00;
        } else {
            LimiteChequeEspecial = valorinicial * 0.50;
        }
    }
}
