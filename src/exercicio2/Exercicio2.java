import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // 1) Ler o tamanho do lado do quadrado
        System.out.print("Digite o tamanho do lado do quadrado: ");
        double lado = leitor.nextDouble();

        // 2) Calcular a area
        // Dica: qual e a formula da area de um quadrado?
        double area = lado * lado;

        // 3) Exibir o resultado na tela
        System.out.printf("A area do quadrado e: %d", area);

        leitor.close();
    }
}
