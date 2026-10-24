// =============================================
// EXERCÍCIO: GENERICS - Testando a Caixa
// =============================================
public class TesteCaixa {
    public static void main(String[] args) {
        // 1) Crie uma Caixa<String> chamada caixaTexto e guarde "Hello Generics"
        Caixa<String> caixaTexto = new Caixa<>("Hello Generics");
        caixaTexto.exibir();
        
        // 2) Crie uma Caixa<Integer> chamada caixaNumero e guarde 123
        Caixa<Integer> caixaNumero = new Caixa<>(123);
        caixaNumero.exibir();
        
        // 3) Crie uma Caixa<Double> chamada caixaDouble e guarde 99.90
        Caixa<Double> caixaDouble = new Caixa<>(99.90);
        caixaDouble.exibir();
        
        // 4) Usando getItem(), imprima a soma de caixaNumero + caixaDouble
        // Dica: use doubleValue() ou apenas some como (double)
        double soma = caixaNumero.getItem() + caixaDouble.getItem();
        System.out.println("Soma: " + soma);
    }
}
