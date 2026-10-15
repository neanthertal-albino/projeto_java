import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // 1) Ler a idade da primeira pessoa
        System.out.print("Digite a idade da primeira pessoa: ");
        int idade1 = leitor.nextInt();

        // 2) Ler a idade da segunda pessoa
        System.out.print("Digite a idade da segunda pessoa: ");
        int idade2 = leitor.nextInt();

        // 3) Calcular a diferenca entre as idades
        // Atencao: "diferenca" nao pode ser negativa!
        int diferenca = Math.abs(idade1 - idade2);

        // 4) Exibir o resultado na tela
        System.out.printf("A diferenca de idade e: %d anos", diferenca);

        leitor.close();
    }
}
