// EXERCÍCIO 17 — Calculadora de áreas com INTERFACE.
// A MESMA pergunta ("qual é a sua área?") vai para figuras diferentes.
// Diferença pros exercícios 15/16: o método calcularArea() RETORNA um double
// (não é void) — então dá pra guardar o resultado numa variável e imprimir.

public class Exercicio17 {
    public static void main(String[] args) {

        // ---- 1) Criar as três figuras ----
        Quadrado quad = new Quadrado(5);
        // COMPLETAR: crie um Retangulo com base 8 e altura 3 (variável: ret)
        Retangulo ret = new Retangulo(8, 3);
        // COMPLETAR: crie um Circulo com raio 2.5 (variável: circ)
        Circulo circ = new Circulo(2.5);

        // ---- 2) Calcular a área de cada uma (chamada direta) ----
        // Como calcularArea() DEVOLVE um valor, o resultado pode ir
        // direto pra dentro do printf com %.1f (ou %.2f).
        System.out.println("Quadrado 5x5 = " + quad.calcularArea());
        System.out.println("Retangulo 8x3 = " + ret.calcularArea());
        System.out.println("Circulo = " + circ.calcularArea());
        // COMPLETAR: imprima a área do retângulo e do círculo do mesmo jeito
        System.out.println();

        // ---- 3) O PULO DO GATO: variável do tipo da INTERFACE ----
        FormaGeometrica forma = quad;
        forma = circ;
        forma = ret;
        System.out.println(forma.getNome() + " -> área: " + forma.calcularArea());
        // COMPLETAR: reaponte 'forma' pro retângulo e pro círculo.
        //           Em cada caso, imprima getNome() e calcularArea().
        System.out.println();

        // ---- 4) BÔNUS: array do tipo da interface + for ----
        FormaGeometrica[] figuras = { quad, ret, circ };

        for (int i = 0; i < figuras.length; i++) {
            System.out.println("Figura: " + figuras[i].getNome());
            System.out.println(figuras[i].calcularArea());
        }

        // COMPLETAR: um for que percorre o array e, para cada figura,
        // imprime o nome e a área.
        // Lembrete: figuras.length e figuras[i]

        // ---- 5) Teste de erro ----
        // Tente "new FormaGeometrica();" e veja o compilador recusar.
        // Interface é contrato, não molde de objeto. Depois desfaça.
    }
}
