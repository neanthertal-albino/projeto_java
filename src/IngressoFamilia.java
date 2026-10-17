// Ingresso FAMÍLIA: herda de Ingresso e o valor depende do NÚMERO DE PESSOAS.
// Regra: valor cheio × nº de pessoas; se pessoas > 3, ganha 5% de desconto.

public class IngressoFamilia extends Ingresso {

    // Campo exclusivo desta subclasse: quantas pessoas no ingresso.
    private int numeroPessoas;

    // Construtor: repassa os 3 dados para o pai (super) e guarda as pessoas aqui.
    public IngressoFamilia(String nomeFilme, double valor, boolean dublado, int numeroPessoas) {
        super(nomeFilme, valor, dublado);
        this.numeroPessoas = numeroPessoas;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    // Outro polimorfismo: mesmo método calcularValor(), regra diferente.
    @Override
    public double calcularValor() {
        // Passo 1: multiplicar o valor base pelo número de pessoas.
        // Dica: getValor() * numeroPessoas
        var total = getValor() * numeroPessoas;

        // Passo 2: se número de pessoas for MAIOR que 3, aplicar 5% de desconto.
        // Desconto de 5% = multiplicar por 0.95 (ou subtrair 5% do total).
        // Dica: use if (numeroPessoas > 3) { ... }
        if (numeroPessoas > 3) {
            total = total * 0.95;
        } 

        // COMPLETAR: monte a regra completa e devolva o valor final.
        return total;
    }
}
