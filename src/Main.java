import util.Mensagem;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // String e System ja funcionam sem import (java.lang e automatico)
        Scanner leitor = new Scanner(System.in);

        List<String> linguagens = List.of("Python", "JavaScript", "Java");
        linguagens.forEach(l -> System.out.println(l));

        int ano = 2026;
        double versao = 21.0;
        boolean aprendendo = true;
        char inicial = 'D';
        String nome = "DIO";
        var cidade = "Sao Paulo";
        final double PI = 3.14;

        System.out.println("Nome: " + nome);
        System.out.println("Ano: " + ano);
        System.out.println("Versao: " + versao);
        System.out.println("Aprendendo? " + aprendendo);
        System.out.println("Inicial: " + inicial);
        System.out.println("Cidade: " + cidade);
        System.out.println("PI: " + PI);

        System.out.println("Qual é o seu nome?: ");
        String outronome = leitor.nextLine();

        System.out.println("Sua idade?: ");
        int idadex = leitor.nextInt();

        System.out.printf("Olá, seu nome é %s e sua idade é %s\n", outronome, idadex);
        System.out.println(Mensagem.formatar("Primeiro projeto em Java!"));

        leitor.close();
    }
}
