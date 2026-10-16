import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Carro carro = new Carro(); // nasce desligado, marcha 0, velocidade 0

        int escolha;
        do {
            System.out.println("=== CONTROLE DO CARRO ===");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Trocar marcha");
            System.out.println("6 - Virar (esquerda/direita)");
            System.out.println("7 - Verificar velocidade");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            escolha = leitor.nextInt();

            switch (escolha) {
                case 1:
                    carro.ligar();
                    break;

                case 2:
                    carro.desligar();
                    break;

                case 3:
                    // TODO: acelerar
                    break;

                case 4:
                    // TODO: diminuir velocidade
                    break;

                case 5:
                    System.out.print("Qual marcha? (0 a 6): ");
                    int novaMarcha = leitor.nextInt();
                    carro.trocarMarcha(novaMarcha);
                    break;

                case 6:
                    // TODO: virar
                    break;

                case 7:
                    carro.verificarVelocidade();
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
