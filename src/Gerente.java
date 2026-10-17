// GERENTE: herda de Usuario. É SEMPRE administrador (true).
// Métodos exclusivos: gerar relatório financeiro e consultar vendas.

public class Gerente extends Usuario {

    public Gerente(String nome, String email, String senha) {
        // Repassa os dados para o pai e fixa administrador = true.
        super(nome, email, senha, true);
    }

    public void gerarRelatorioFinanceiro() {
        // COMPLETAR: mostre uma mensagem de relatório financeiro
        // (ex.: "Gerando relatório financeiro para o gerente " + getNome())
        System.out.printf("Gerando relatório financeiro para o gerente %s\n", getNome());
    }

    public void consultarVendas() {
        // COMPLETAR: mostre uma mensagem de consulta de vendas
        System.out.println("Consultando as vendas...\n");
    }
}
