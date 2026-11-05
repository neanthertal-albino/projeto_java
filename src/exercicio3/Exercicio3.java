import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // 1) Ler a base do retangulo
        System.out.print("Digite a base do retangulo: ");
        double base = leitor.nextDouble();

        // 2) Ler a altura do retangulo
        System.out.print("Digite a altura do retangulo: ");
        double altura = leitor.nextDouble();

        // 3) Calcular a area
        // Dica: qual e a formula da area de um retangulo?
        double area = base * altura;

        // 4) Exibir o resultado na tela
        System.out.printf("A area do retangulo e: %f", area);

        leitor.close();
    }
}
