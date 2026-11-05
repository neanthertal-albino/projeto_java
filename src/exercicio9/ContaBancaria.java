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

    // Recebe um valor e subtrai do saldo, com regra do cheque especial
    public void Sacar(double valor) {
        // O que ainda dá pra usar: saldo + a parte do limite que não foi usada ainda
        double disponivel = saldo + (LimiteChequeEspecial - ChequeEspecialUsado);

        if (valor > disponivel) {
            System.out.println("Saque não autorizado: valor acima do disponível.");
        } else if (valor > saldo) {
            // Estourou o saldo: a diferença vai pro cheque especial
            ChequeEspecialUsado = ChequeEspecialUsado + (valor - saldo);
            saldo = 0;
        } else {
            // Cabe no saldo: só subtrai
            saldo = saldo - valor;
        }
    }

    // Pagar boleto: o dinheiro sai da conta igual a um saque
    public void PagarBoleto(double valor) {
        // Reaproveita o Sacar em vez de reescrever a regra toda
        Sacar(valor);
    }

    // Checa se a conta está usando cheque especial (usado > 0)
    public void VerificarChequeEspecial() {
        if (ChequeEspecialUsado > 0) {
            System.out.printf("Está usando cheque especial: R$%.2f%n", ChequeEspecialUsado);
        } else {
            System.out.println("Não está usando cheque especial.");
        }
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
