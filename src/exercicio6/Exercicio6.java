import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // 1) Ler a altura (em metros) e o peso (em kg)
        System.out.print("Digite sua altura (ex: 1,75): ");
        double altura = leitor.nextDouble();

        System.out.print("Digite seu peso (ex: 70,5): ");
        double peso = leitor.nextDouble();

        // 2) Calcular o IMC = peso / (altura * altura)
        double imc = peso / (altura * altura);

        // 3) Mostrar o IMC com 2 casas decimais
        System.out.printf("Seu IMC e: %.2f%n", imc);

        // 4) Classificar o resultado com if / else if / else
        //    IMPORTANTE: o Java testa de cima para baixo e para na PRIMEIRA
        //    condicao verdadeira. Por isso, coloque as faixas na ordem correta!
        if (imc < 18.5) {
            System.out.println("Abaixo do peso (magreza)");
        } else if (imc < 25) {
            System.out.println("Peso normal");
        } else if (imc < 30.0) {
            System.out.println("Sobrepeso");
        } else if (imc < 35) {
            System.out.println("Obesidade grau I");
        } else if (imc < 40) {
            System.out.println("Obesidade grau II");
        } else {
            System.out.println("Obesidade grau III (morbida)");
        }

        leitor.close();
    }
}
