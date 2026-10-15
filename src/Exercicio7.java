import java.util.Scanner;

public class Exercicio7 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // 1) Ler o primeiro numero (o menor do intervalo)
        System.out.print("Digite o primeiro numero: ");
        int primeiro = leitor.nextInt();

        // 2) Ler o segundo numero (o maior do intervalo)
        System.out.print("Digite o segundo numero (maior que o primeiro): ");
        int segundo = leitor.nextInt();

        // 3) Escolher entre par e impar.
        //    Vamos pedir: digite 1 para PARES ou 2 para IMPARES
        System.out.print("Digite 1 para PARES ou 2 para IMPARES: ");
        int escolha = leitor.nextInt();

        // 4) Percorrer o intervalo em ORDEM DECRESCENTE, incluindo os dois
        //    numeros informados. Lembre-se do laco for:
        //       for (inicio; condicao; passo)
        //    - inicio: comecar pelo segundo numero (o maior)
        //    - condicao: continuar ENQUANTO nao chegar no primeiro (use >=
        //      para incluir o primeiro numero no intervalo!)
        //    - passo: como e decrescente, o numero TEM QUE DIMINUIR
        if (escolha == 1 || escolha == 2) {
            for (int i = segundo; i >= primeiro; i--) {

            // 5) Mostrar apenas os numeros que batem com a escolha:
            //    - se digitou 1 (pares):     i % 2 == 0
            //    - se digitou 2 (impares):  i % 2 != 0
            //    Use if / else if com o operador && ("e") que voce ja conhece
                if (escolha == 1 && i % 2 == 0) {
                    System.out.println(i);

                    
                } else if (escolha == 2 && i % 2 != 0) {
                    System.out.println(i);
                }
            
        }
        }
        else {
            System.out.println("Valor de escolha inválido");
        }

        leitor.close();
    }
}
