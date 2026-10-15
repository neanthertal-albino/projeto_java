import java.util.Scanner;

public class Exercicio5 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // 1) Ler o numero que o usuario quer ver a tabuada
        System.out.print("Digite um numero: ");
        int numero = leitor.nextInt();

        // 2) Gerar a tabuada desse numero, de 1 ate 10
        // Dica: um contador "i" deve comecar em 1 e ir aumentando ate 10.
        // Preencha a linha do for abaixo:
        for (int i = 1; i <= 10; i++) {
            // 3) Calcule o resultado: numero x i
            int resultado = i * numero;

            // 4) Exibir no formato: "5 x 1 = 5"
            System.out.printf("%d x %d = %d%n", numero, i, resultado);
        }

        leitor.close();
    }
}
