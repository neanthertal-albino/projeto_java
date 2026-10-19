// CÍRCULO — implementação de FormaGeometrica.
// Mesmo contrato: devolve a área. Conta: PI * raio * raio.
//
// Pegadinha nova: o PI não é você que digita — o Java já conhece!
// Use Math.PI (uma constante gigante: 3.141592653589793...).
// "Math" é uma classe que vem pronta no Java, com coisas matemáticas.

public class Circulo implements FormaGeometrica {

    private double raio;

    // COMPLETAR: construtor com um parâmetro double chamado raio

    @Override
    public double calcularArea() {
        // COMPLETAR: devolva a área do círculo: Math.PI * raio * raio
        // Dica: return Math.PI * raio * raio;
        return 0; // troque pelo cálculo certo
    }

    @Override
    public String getNome() {
        return "Círculo"; // já pronto
    }
}
