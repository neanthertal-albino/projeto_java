// EXERCÍCIO 12 — Hierarquia de Ingressos de Cinema
// A classe Ingresso é a CLASSE BASE (superclasse) de todas as demais.
// MeiaEntrada e IngressoFamilia vão HERDAR dela usando "extends".

public class Ingresso {

    // Campos da base: todo ingresso tem esses 3 dados
    private String nomeFilme;
    private double valor;
    private boolean dublado; // true = dublado, false = legendado

    // Construtor: recebe os 3 valores e guarda nos campos
    public Ingresso(String nomeFilme, double valor, boolean dublado) {
        this.nomeFilme = nomeFilme;
        this.valor = valor;
        this.dublado = dublado;
    }

    // GETTERS: métodos que DEVOLVEM o valor dos campos privados.
    // As subclasses vão precisar de getValor() para calcular o preço.

    public String getNomeFilme() {
        return nomeFilme;
    }

    public double getValor() {
        // COMPLETAR: devolva o valor do campo valor
        return valor;
    }

    public boolean isDublado() {
        return dublado;
    }

    // Método que devolve "DUBLADO" ou "LEGENDADO" em texto.
    // Dica: use ternário → (condição) ? seTrue : seFalse
    public String getFormato() {
        // COMPLETAR: se dublado for true devolve "DUBLADO", senão "LEGENDADO"
        if (dublado == true) {
            return "DUBLADO";
        } else {
            return "LEGENDADO";
        }
    }

    // Este é o método que cada subclasse vai SOBRESCREVER com @Override.
    // Na base, o valor real é o próprio valor cheio.
    public double calcularValor() {
        // COMPLETAR: devolva o valor cheio (sem desconto)
        return valor;
    }

    // Método de apoio para mostrar as informações do ingresso na tela.
    public String toString() {
        return "Filme: " + nomeFilme
             + " | Formato: " + getFormato()
             + " | Valor: R$ " + calcularValor();
    }
}
