// EXERCÍCIO 18 — Calculadora de soma e subtração com números digitados de uma vez.
// O usuário digita algo tipo:  10, 5, 2
// e o programa soma (ou subtrai) tudo e mostra o resultado.
//
// O pulo do gato aqui é TRANSFORMAR TEXTO em NÚMEROS:
//   1) ler a linha inteira como String (leitor.nextLine())
//   2) quebrar a String em pedaços usando a vírgula como separador
//      -> String.split(",") devolve um array de String: {"10", " 5", " 2"}
//   3) cada pedaço ainda é TEXTO, então converter com Double.parseDouble(...)
//      DICA: passe .trim() antes pra tirar os espaços sobrando (" 5" -> "5")
//   4) aí sim dá pra fazer a conta com os doubles
//
// Estrutura sugerida (você decide os nomes e a ordem):
//   - perguntar a operação (+ ou -)
//   - ler a linha com os números separados por vírgula
//   - split + conversão
//   - percorrer o array calculando
//   - imprimir o resultado
//
// Lembretes:
//   - para SOMAR tudo: comece com resultado = 0 e vá acumulando.
//   - para SUBTRAIR: comece com o PRIMEIRO número e vá tirando os outros
//     (se começar do 0, tudo fica negativo).
//   - o array tem tamanho fixo: partes.length te diz quantos números vieram.
//   - duas opções de organização: fazer tudo no main com um for, ou criar
//     métodos que recebem double[] e devolvem double (mais organizado).

import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // TODO: perguntar qual operação o usuário quer (soma ou subtração)
        //       dica: leia como String e compare com .equals()
        System.out.println("Escolha uma operação: + ou - ");
        var operacao = leitor.nextLine();

        // TODO: ler a linha inteira com os números separados por vírgula
        System.out.println("Selecione os números que deseja (separe-os por vírgulas): ");
        var num = leitor.nextLine();

        // TODO: transformar a linha em array de String (split)
        // TODO: converter cada pedaço em double (parseDouble + trim)

        String[] partes = num.split(",");

        double resultado = 0;
        
        for (int i = 0; i < partes.length; i++) {
            double numero = Double.parseDouble(partes[i].trim()); 
            if (i == 0 && operacao.equals("-")) {
                resultado = numero;
            } else if (operacao.equals("+")) {
                resultado += numero;
            } else if (operacao.equals("-")) {
                resultado -= numero;
            } else {
                System.out.println("Deixa de ser viado");
                return;
            }
        }


        // TODO: fazer a conta (no main com um for, ou em métodos separados)


        // TODO: mostrar o resultado

        System.out.printf("O resultado é %s\n", resultado);

        leitor.close();
    }
}
