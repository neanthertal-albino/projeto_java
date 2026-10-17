// EXERCÍCIO 13 — Testando a hierarquia de usuários de um sistema.
// Crie um de cada tipo e exercite os métodos.

public class Exercicio13 {
    public static void main(String[] args) {

        // ---- 1) GERENTE ----
        // "Ana", "ana@empresa.com", senha "1234"
        // COMPLETAR: Gerente gerente = new Gerente(...);
        Gerente gerente = new Gerente("Ana", "ana@empresa.com", "1234");

        // ---- 2) VENDEDOR ----
        // "Bruno", "bruno@empresa.com", senha "abcd"
        // COMPLETAR: Vendedor vendedor = new Vendedor(...);
        Vendedor vendedor = new Vendedor("Bruno", "bruno@empresa.com", "abcd");

        // ---- 3) ATENDENTE ----
        // "Carla", "carla@empresa.com", senha "xyz"
        // COMPLETAR: Atendente atendente = new Atendente(...);
        Atendente atendente = new Atendente("Carla", "carla@empresa.com", "xyz");

        // ---- Testando o que é comum (herdado da base) ----
        // COMPLETAR: descomente e observe
        gerente.realizarLogin();
        vendedor.realizarLogin();
        atendente.realizarLogin();

        // ---- Testando o que é exclusivo de cada um ----
        // COMPLETAR: descomente e observe
        gerente.gerarRelatorioFinanceiro();
        gerente.consultarVendas();

        vendedor.realizarVenda();
        vendedor.realizarVenda();
        vendedor.realizarVenda();
        vendedor.consultarVendas();

        atendente.receberPagamento(50.0);
        atendente.receberPagamento(30.0);
        atendente.fecharCaixa();

        // ---- Confere o flag de administrador de cada um ----
        // COMPLETAR: descomente e observe (Gerente = true, os outros = false)
        System.out.println("Gerente é admin? " + gerente.isAdministrador());
        System.out.println("Vendedor é admin? " + vendedor.isAdministrador());
        System.out.println("Atendente é admin? " + atendente.isAdministrador());

        // ---- Bônus: alterar dados e senha ----
        // COMPLETAR:
        gerente.alterarSenha("1234", "novaSenha"); // deve funcionar
        gerente.alterarSenha("errada", "outra");   // deve falhar
        gerente.alterarDados("Ana Silva", "ana.silva@empresa.com");
    }
}
