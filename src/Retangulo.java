// RETÂNGULO — implementação de FormaGeometrica.
// Mesmo contrato do Quadrado: devolve a área. Conta diferente: base * altura.
// Atenção: são DOIS atributos agora (base e altura) — o construtor recebe os dois.

public class Retangulo implements FormaGeometrica {

    private double base;
    private double altura;

    public Retangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    // COMPLETAR: construtor com DOIS parâmetros (double base, double altura)
    // e guarde os dois com this.base = base; this.altura = altura;

    @Override
    public double calcularArea() {
        // COMPLETAR: devolva a área do retângulo (base * altura)
        // Dica: return base * altura;
        return base * altura; // troque pelo cálculo certo
    }

    @Override
    public String getNome() {
        return "Retângulo"; // já pronto
    }
}
