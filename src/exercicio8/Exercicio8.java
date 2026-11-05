import java.util.Scanner;

public class Exercicio8 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // 1) Leia o numero inicial (sera o "divisor" do problema)
        System.out.print("Digite o numero inicial: ");
        int inicial = leitor.nextInt();

        // 2) Agora o programa deve ficar pedindo OUTROS numeros.
        //    A EXECUCAO PARA quando:
        //       - o numero informado for >= inicial  E
        //       - o resto da divisao pelo inicial for DIFERENTE de 0
        //
        //    Enquanto o resto for 0, continuamos pedindo.
        //    Numeros MENORES que o inicial sao ignorados (nao param o programa!).
        //
        //    Como sempre vamos pedir pelo menos um numero, o do/while
        //    e a estrutura ideal:
        //
        //       do {
        //           ...
        //       } while (___________);
        //
        //    Dica: use uma variavel booleana "parar" para controlar a saida.

        boolean parar = false;

        do {
            System.out.print("Digite o proximo numero: ");
            int numero = leitor.nextInt();

            // 3) Primeiro caso: numero MENOR que o inicial.
            //    Ele deve ser apenas IGNORADO (o programa continua!).
            //    Complete a condicao do if:
            if (numero < inicial) {
                System.out.println("Numero menor que o inicial, ignorado!");

            // 4) Segundo caso: numero >= inicial E resto DIFERENTE de 0.
            //    Aqui o programa PARA: marque parar = true.
            } else if (numero >= inicial && numero % inicial != 0) {
                System.out.println("Resto diferente de 0. Fim do programa!");
                parar = true;

            // 5) Terceiro caso: resto igual a 0 (numero divisivel pelo inicial).
            //    O programa CONTINUA pedindo numeros.
            } else {
                System.out.println("Resto igual a 0, vamos continuar!");
            }

        } while (!parar);

        leitor.close();
    }
}
