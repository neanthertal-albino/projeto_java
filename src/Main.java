import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String name = leitor.nextLine();

        System.out.println("Digite o ano do seu nascimento: ");
        int ano = leitor.nextInt();

        int anoatual = 2026;
        int idade = anoatual - ano;

        System.out.printf("Olá %s, você tem %d anos.", name, idade);
        leitor.close();

    }
}