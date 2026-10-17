// VENDEDOR: herda de Usuario. NUNCA é administrador (false).
// Guarda a quantidade de vendas e tem os métodos ligados a venda.

public class Vendedor extends Usuario {

    // Campo exclusivo do vendedor. int nasce valendo 0 automaticamente.
    private int quantidadeVendas;

    public Vendedor(String nome, String email, String senha) {
        // COMPLETAR: chame super(...) com administrador = false
        super(nome, email, senha, false);
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void realizarVenda() {
        // COMPLETAR: incremente quantidadeVendas em 1
        // e mostre o total atual (ex.: "Venda registrada! Total: " + ...)
        quantidadeVendas += 1;
        System.out.printf("Venda registrada! Total: %s\n", quantidadeVendas);
    }

    public void consultarVendas() {
        // COMPLETAR: mostre a quantidade de vendas do vendedor
        System.out.printf("Total de vendas: %s\n", quantidadeVendas);
    }
}
