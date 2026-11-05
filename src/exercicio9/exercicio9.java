import java.util.Scanner;

public class exercicio9 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o valor depositado nessa conta: ");
        double valorinicial = leitor.nextDouble();

        ContaBancaria conta = new ContaBancaria(valorinicial);

        int escolha;
        do {
            System.out.println("=== MENU BANCÁRIO ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar um boleto");
            System.out.println("6 - Verificar se está usando cheque especial");
            System.out.println("0 - Sair");
            System.out.print("Digite sua opção: ");
            escolha = leitor.nextInt();

            switch (escolha) {
                case 1:
                    conta.ConsultarSaldo();
                    break;

                case 2:
                    conta.ConsultarChequeEspecial();
                    break;

                case 3:
                    // Pede o valor na tela e manda pra conta depositar
                    System.out.print("Quanto deseja depositar? ");
                    double valorDeposito = leitor.nextDouble();
                    conta.Depositar(valorDeposito);
                    break;

                case 4:
                    System.out.print("Quanto deseja sacar? ");
                    double valorSaque = leitor.nextDouble();
                    conta.Sacar(valorSaque);
                    break;

                case 5:
                    System.out.print("Valor do boleto? ");
                    double valorBoleto = leitor.nextDouble();
                    conta.PagarBoleto(valorBoleto);
                    break;

                case 6:
                    conta.VerificarChequeEspecial();
                    break;

                case 0:
                    System.out.println("Saindo... Até mais!");
                    break;

                default:
                    System.out.println("Valor inválido");
                    break;
            }
        } while (escolha != 0);

        leitor.close();
    }
}
