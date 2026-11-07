// EXERCÍCIO 21 — O CLIENTE consumindo a API.
//
// Esta classe faz o papel de OUTRO sistema que usa a calculadora.
// Repare: ela só chama os métodos públicos da ApiCalculadora.
// Não sabe (nem precisa saber) como as contas são feitas por dentro.

public class Exercicio21 {
    public static void main(String[] args) {

        // ---- 1) "Conectar" na API ----
        // Criar o objeto é como "entrar" no serviço.
        ApiCalculadora api = new ApiCalculadora();

        // ---- 2) Consumir cada operação (a API responde) ----
        // Gabarito do primeiro:
        System.out.println("Soma: " + api.somar(10, 5));

        // COMPLETAR: mostre a subtração de 10 e 5 chamando api.subtrair(...)
        // COMPLETAR: mostre a multiplicação de 10 e 5 chamando api.multiplicar(...)
        // COMPLETAR: mostre a divisão de 10 por 5 chamando api.dividir(...)

        System.out.println();

        // ---- 3) Usar um método que esconde a "receita" ----
        // A gente só pede a média; a soma e a divisão acontecem por dentro.
        double[] notas = { 7.0, 8.5, 9.0, 6.5 };
        System.out.println("Media: " + api.media(notas));

        // ---- 4) A API se protege sozinha ----
        // Tente dividir por zero: a regra está dentro da API, não no cliente.
        System.out.println("Divisao por zero: " + api.dividir(10, 0));

        // ---- 5) Comparação com a API do Java ----
        // É a MESMA ideia: chamamos, recebemos o resultado, sem ver a cozinha.
        System.out.println("Math.abs(-5): " + Math.abs(-5));
        System.out.println("Math.max(3, 9): " + Math.max(3, 9));
    }
}
