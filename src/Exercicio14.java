// EXERCÍCIO 14 — Testando a hierarquia de relógios.
// Crie um relógio brasileiro e um americano, ajuste as horas e sincronize.

public class Exercicio14 {
    public static void main(String[] args) {

        // ---- 1) Relógio BRASILEIRO (24h) ----
        // COMPLETAR: RelogioBrasileiro br = new RelogioBrasileiro();
        RelogioBrasileiro br = new RelogioBrasileiro();
        RelogioAmericano usa = new RelogioAmericano();

        br.setHora(15);
        br.setMinuto(30);
        br.setSegundo(45);

        // ---- 2) Relógio AMERICANO (12h) ----
        // COMPLETAR: RelogioAmericano usa = new RelogioAmericano();

        // Mostra os dois no formato HH:MM:SS
        // COMPLETAR:
        System.out.println("Brasileiro: " + br.getHoraFormatada());
        System.out.println("Americano : " + usa.getHoraFormatada());

        // ---- 3) Sincronizando: americano recebe a hora do brasileiro ----
        // O método sincronizar recebe um Relogio (qualquer implementação),
        // então o americano tem que CONVERTER 15h (24h) para 3h (12h).
        // COMPLETAR:
        usa.sincronizar(br);
        System.out.println("Americano após sincronizar: " + usa.getHoraFormatada());

        // ---- 4) Teste de validação ----
        // O americano não aceita hora 13. Deve avisar e não gravar.
        // COMPLETAR:
        usa.setHora(13);

        // ---- 5) Bônus: brasileiro recebendo do americano ----
        // COMPLETAR:
        br.sincronizar(usa);
        System.out.println("Brasileiro após receber do americano: " + br.getHoraFormatada());

        // ---- 6) Confirma que Relogio é abstrata ----
        // Se você tentar "new Relogio();" NÃO vai compilar. Testa e veja o erro!
    }
}
