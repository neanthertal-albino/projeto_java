// DINHEIRO — implementação de FormaPagamento.
// Aqui o pagamento depende de quanto o cliente ENTREGOU: pode faltar ou sobrar troco.
// É a mesma pegadinha de lógica do Exercicio9 (cheque especial): compare os valores!

public class Dinheiro implements FormaPagamento {

    private double valorEntregue; // quanto o cliente entregou no caixa

    public Dinheiro(double valorEntregue) {
        this.valorEntregue = valorEntregue;
    }

    @Override
    public void pagar(double valor) {
        // Regras:
        //  - entregou MENOS que o valor  -> avise que é insuficiente e mostre quanto falta
        //  - entregou MAIS que o valor   -> confirme e mostre o troco
        //  - entregou EXATAMENTE        -> confirme e diga que não há troco
        double troco = valorEntregue - valor;
        if (valorEntregue > valor) {
            System.out.printf("O cliente pagou R$ %.2f, o troco será de R$ %.2f\n", valorEntregue, troco);
        } else if (valorEntregue < valor) {
            System.out.printf("Cliente entregou valor insuficiente (R$ %.2f) para pagar R$ %.2f, o cliente precisa pagar mais R$ %.2f\n", valorEntregue, valor, valor - valorEntregue);
        } else {
            System.out.printf("O cliente pagou o valor exato (%.2f)\n", valor);
        }

        // COMPLETAR: if / else if / else com as três regras acima.
        // Use printf com %.2f para os valores em dinheiro.
        // Dica: se troco for negativo, quanto falta é -troco (Math.abs também serve).


    }

    @Override
    public String getNome() {
        // COMPLETAR: devolva o texto "Dinheiro"
        return "Dinheiro";
    }
}
