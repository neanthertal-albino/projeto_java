// REDES SOCIAIS — implementação de ServicoMensagem.
// Mesmo contrato, comportamento diferente: publica no perfil.

public class RedesSociais implements ServicoMensagem {

    private String perfil; // em qual perfil a mensagem será publicada

    // COMPLETAR: construtor com um parâmetro String chamado perfil

    public RedesSociais(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public void enviar(String mensagem) {
        // COMPLETAR: imprima algo no formato:
        // [Redes Sociais -> @perfil] <mensagem>
        System.out.printf("[Redes sociais -> %s] %s%n", perfil, mensagem);
    }

    @Override
    public String getNome() {
        return "Redes Sociais"; // já pronto
    }
}
