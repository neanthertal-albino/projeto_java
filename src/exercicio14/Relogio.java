// EXERCÍCIO 14 — Hierarquia de relógios para diferentes lugares do mundo.
//
// Relogio é uma CLASSE ABSTRATA: é o molde comum, mas NÃO pode ser
// instanciada sozinha — "new Relogio()" NÃO compila. Só as filhas existem.
//
// A palavra "abstract" na classe avisa isso ao Java.
// Ela define:
//  - hora, minuto, segundo (com getters/setters validando as regras)
//  - getHoraFormatada() -> "HH:MM:SS"
//  - sincronizar(Relogio outro) -> ABSTRATO: cada filha decide como fazer

public abstract class Relogio {

    private int hora;
    private int minuto;
    private int segundo;

    // ---- SETTERS com as regras de funcionamento de um relógio ----

    public void setHora(int hora) {
        // Regra geral (formato 24h): hora de 0 a 23.
        // COMPLETAR: só guarde se estiver na faixa válida; senão avise
        // (ex.: System.out.println("Hora inválida: " + hora);)
        if (hora >= 0 && hora <= 23) {
            this.hora = hora;
            System.out.println("Hora válida");
        } else {
            System.out.printf("Hora inválida: %s\n", hora);
        }
    }

    public void setMinuto(int minuto) {
        // Regra: minuto de 0 a 59.
        // COMPLETAR
        if (minuto >= 0 && minuto <= 59) {
            this.minuto = minuto;
            System.out.println("Minuto válido");
        } else {
            System.out.printf("Minuto inválido: %s", minuto);
        }
    }

    public void setSegundo(int segundo) {
        // Regra: segundo de 0 a 59.
        // COMPLETAR
        if (segundo >= 0 && segundo <= 59) {
            this.segundo = segundo;
            System.out.println("Segundo válido");
        } else {
            System.out.printf("Segundo inválido: %s", segundo);
        }
    }

    // ---- GETTERS ----
    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    // Devolve a hora no formato HH:MM:SS (com zero à esquerda).
    // Dica: String.format("%02d:%02d:%02d", hora, minuto, segundo)
    //       "%02d" = inteiro com no mínimo 2 dígitos (completa com 0).
    public String getHoraFormatada() {
        // COMPLETAR
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    // MÉTODO ABSTRATO: sem corpo! Repare que termina em ";" direto.
    // Quem estende Relogio é OBRIGADO a implementar este método.
    // Recebe um relógio de QUALQUER implementação e usa os dados dele
    // para ajustar ESTE relógio.
    public abstract void sincronizar(Relogio outro);
}
