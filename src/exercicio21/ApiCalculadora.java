// EXERCÍCIO 21 — O QUE É UMA API, NA PRÁTICA.
//
// Esta classe é a "API": a PORTA DE ENTRADA oficial da calculadora.
// Quem usa de fora (o cliente) só conhece os métodos PUBLIC abaixo.
// Ele chama pelo nome, passa os valores e recebe o resultado —
// sem precisar saber COMO a conta é feita por dentro ("cozinha" escondida).
//
// É exatamente isso que fazemos com a API do Java todo dia:
//   Math.abs(-5)        -> a gente chama, o Java resolve internamente.
//   String.split(",")   -> mesma ideia.
//
// Aqui a gente é quem ESTÁ CRIANDO a API desta calculadora.

public class ApiCalculadora {

    // ---- Os "endpoints" da nossa API (o que fica exposto pro cliente) ----

    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        // A API se protege: quem chamou não precisa lembrar dessa regra.
        // Num sistema real a gente avisaria com uma EXCEÇÃO (tema do módulo
        // de Spring); aqui devolvemos 0 pra manter o exemplo simples.
        if (b == 0) {
            return 0;
        }
        return a / b;
    }

    // Método que usa a própria API por dentro (detalhe interno).
    // O cliente não vê que a média soma + divide: só pede a media().
    public double media(double[] valores) {
        double total = somar(0, 0); // começa em 0 usando a própria API
        for (int i = 0; i < valores.length; i++) {
            total = somar(total, valores[i]);
        }
        return dividir(total, valores.length);
    }
}
