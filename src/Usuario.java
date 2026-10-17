// EXERCÍCIO 13 — Hierarquia de usuários de um sistema.
// A classe Usuario é a CLASSE BASE: guarda o que TODO usuário tem em comum
// (nome, email, senha e se é administrador) e os métodos comuns.
// Gerente, Vendedor e Atendente vão HERDAR dela com "extends".

public class Usuario {

    // Campos comuns a todos os usuários (private = encapsulados)
    private String nome;
    private String email;
    private String senha;
    private boolean administrador; // true = admin, false = não admin
    private boolean logado;        // estado: está logado agora?

    // Construtor: recebe nome, email, senha e o administrador.
    // Quem for filho chama super(...) e decide o valor do administrador.
    public Usuario(String nome, String email, String senha, boolean administrador) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.administrador = administrador;
        this.logado = false; // todo usuário nasce deslogado
    }

    // ---- GETTERS E SETTERS ----

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        // COMPLETAR: guarde o novo nome no campo
        this.nome = nome;    
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // COMPLETAR
        this.email = email;
    }

    // Não faz sentido um getter público de senha (segurança!),
    // mas o setter é usado lá dentro do alterarSenha.
    public void setSenha(String senha) {
        // COMPLETAR
        this.senha = senha;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public boolean isLogado() {
        return logado;
    }

    // ---- MÉTODOS COMUNS A TODOS OS USUÁRIOS ----

    public void realizarLogin() {
        // COMPLETAR: marque logado = true e mostre "Login realizado: <nome>"
        // Dica: use this.logado = true e getNome()
        this.logado = true;
        System.out.printf("Seja bem-vindo, %s\n", getNome());
    }

    public void realizarLogoff() {
        // COMPLETAR: marque logado = false e mostre uma mensagem de saída
        this.logado = false;
        System.out.printf("Saindo da conta de %s\n", getNome());
    }

    public void alterarDados(String novoNome, String novoEmail) {
        // COMPLETAR: use os setters (this.setNome(...) e this.setEmail(...))
        // e mostre uma mensagem de "dados alterados"
        this.setNome(novoNome);
        this.setEmail(novoEmail);
        System.out.println("Dados alterados com sucesso!");
    }

    public void alterarSenha(String senhaAtual, String novaSenha) {
        // Regra: só troca se a senhaAtual for IGUAL à senha guardada.
        // Dica: compare Strings com .equals() (NUNCA com ==)
        // COMPLETAR: se bater, use setSenha(novaSenha); senão avise que falhou
        if (senhaAtual.equals(senha)) {
            this.setSenha(novaSenha);
            System.out.println("Senha alterada com sucesso!\n");
        } else {
            System.out.println("Senha atual incorreta!");
        }
    }
}
