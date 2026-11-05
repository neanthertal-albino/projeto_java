// EXERCÍCIO 12 — Testando a hierarquia de ingressos de cinema.
// Aqui criamos os 3 tipos de ingresso e mostramos o valor real de cada um.

public class Exercicio12 {
    public static void main(String[] args) {
        Ingresso normal = new Ingresso("Oppenheimer", 30, false);
        MeiaEntrada meia = new MeiaEntrada("Barbie", 40, true);
        IngressoFamilia familia = new IngressoFamilia("Telefone branco", 34, false, 5);
        IngressoFamilia familia3 = new IngressoFamilia("Seila", 40, true, 2);
        // ---- 1) Ingresso NORMAL (classe base) ----
        // Filme "Oppenheimer", valor cheio R$ 30,00, legendado.
        // COMPLETAR: crie o objeto chamando o construtor de Ingresso
        // Ingresso normal = new Ingresso(...);

        // ---- 2) Meia ENTRADA ----
        // Filme "Barbie", valor cheio R$ 40,00, dublado.
        // COMPLETAR: crie o objeto chamando o construtor de MeiaEntrada
        // MeiaEntrada meia = new MeiaEntrada(...);

        // ---- 3) Ingresso FAMÍLIA (4 pessoas) ----
        // Filme "Divertida Mente 2", valor cheio R$ 30,00 por pessoa, dublado, 4 pessoas.
        // COMPLETAR: crie o objeto chamando o construtor de IngressoFamilia
        // IngressoFamilia familia = new IngressoFamilia(...);

        // ---- 4) Ingresso FAMÍLIA (3 pessoas — NÃO ganha desconto) ----
        // Filme "Garfield", valor cheio R$ 25,00 por pessoa, legendado, 3 pessoas.
        // COMPLETAR: crie o objeto chamando o construtor de IngressoFamilia
        // IngressoFamilia familia3 = new IngressoFamilia(...);

        // ---- Mostrando os resultados ----
        // Cada chamada abaixo já usa o método toString() da base,
        // que por sua vez chama calcularValor() — e é AQUI que o polimorfismo
        // entra em ação: cada objeto responde com o seu próprio valor!
        //
        // COMPLETAR: descomente (remova as //) depois de criar os objetos:
        System.out.println("Normal : " + normal);
        System.out.println("Meia   : " + meia);
        System.out.println("Família 4: " + familia);
        System.out.println("Família 3: " + familia3);
    }
}
