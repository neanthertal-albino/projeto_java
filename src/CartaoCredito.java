// CARTÃO DE CRÉDITO — implementação de FormaPagamento.
// Mesmo contrato do Pix, comportamento diferente: parcela a compra.

public class CartaoCredito implements FormaPagamento {

    private int parcelas; // em quantas vezes vai dividir

    public CartaoCredito(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public void pagar(double valor) {
        // Regra: divide o valor pelo número de parcelas e mostra tudo.
        // Ex.: valor 300.00, parcelas 3 -> "Compra de R$ 300.00 no cartão em 3x.
        //       Parcela de R$ 100.00"
        // COMPLETAR: calcule a parcela e imprima com printf.
        // Dica: %.2f para dinheiro (double) e %d para parcelas (int).
        // Lembrete: valor / parcelas já dá double (o Java converte sozinho).
        var resultado = valor / parcelas;
        System.out.printf("O pagamento de R$ %.2f poderá ser feito com %d de R$ %.2f\n", valor, parcelas, resultado);
    }

    @Override
    public String getNome() {
        // COMPLETAR: devolva o texto "Cartão de Crédito"
        // Dica: return "...";
        return "Cartão de Crédito";
    }
}
