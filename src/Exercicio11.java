import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        MaquinaDeBanho maquina = new MaquinaDeBanho(); // começa vazia e limpa

        int escolha;
        do {
            System.out.println("=== PETSHOP: MÁQUINA DE BANHO ===");
            System.out.println("1 - Colocar pet na máquina");
            System.out.println("2 - Retirar pet da máquina");
            System.out.println("3 - Dar banho no pet");
            System.out.println("4 - Abastecer com água");
            System.out.println("5 - Abastecer com shampoo");
            System.out.println("6 - Verificar nível de água");
            System.out.println("7 - Verificar nível de shampoo");
            System.out.println("8 - Verificar se tem pet no banho");
            System.out.println("9 - Limpar máquina");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            escolha = leitor.nextInt();

            switch (escolha) {
                case 1:
                    maquina.colocarPet();
                    break;

                case 2:
                    maquina.retirarPet();
                    break;

                case 3:
                    // TODO: dar banho no pet
                    break;

                case 4:
                    // TODO: abastecer com água
                    break;

                case 5:
                    // TODO: abastecer com shampoo
                    break;

                case 6:
                    // TODO: verificar nível de água
                    break;

                case 7:
                    // TODO: verificar nível de shampoo
                    break;

                case 8:
                    maquina.verificarPet();
                    break;

                case 9:
                    // TODO: limpar máquina
                    break;

                case 0:
                    System.out.println("Encerrando. Até mais!");
                    break;

                default:
                    System.out.println("Valor inválido");
            }
        } while (escolha != 0);

        leitor.close();
    }
}
