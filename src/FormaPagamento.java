// EXERCÍCIO 15 — Interface FormaPagamento.
//
// INTERFACE = CONTRATO puro. Diferente da classe abstrata (Relogio), ela:
//  - NÃO tem campos/estado (os dados moram na classe que implementa)
//  - NÃO tem construtor
//  - só declara O QUE precisa existir, nunca COMO funciona
//
// Regras do Java em uma interface:
//  - os métodos são "public abstract" por padrão — nem precisa escrever
//  - cada método termina em ";" (sem corpo! Quem IMPLEMENTA faz o código)
//  - "new FormaPagamento()" NÃO compila: interface nunca é instanciada
//
// Quem implementa usa a palavra "implements" (em vez de "extends")
// e é OBRIGADO a escrever todos os métodos — senão o Java nem compila.

public interface FormaPagamento {

    // COMPLETAR: declare o método pagar, que recebe um double chamado valor
    // e não devolve nada. (Sem "public", sem corpo — termina em ";")
    // Dica: void pagar(double valor);

    void pagar(double valor);

    // COMPLETAR: declare o método getNome, que devolve um String
    // (o nome da forma de pagamento: "Pix", "Cartão de Crédito"...).
    // Dica: String getNome();

    String getNome();
}
