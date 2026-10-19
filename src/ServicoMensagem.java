// EXERCÍCIO 16 — Interface ServicoMensagem (marketing multicanal).
//
// O enunciado pede: a MESMA mensagem deve poder ser enviada para serviços
// diferentes (SMS, E-mail, Redes Sociais, WhatsApp), e cada serviço precisa
// ter um MÉTODO QUE RECEBE A MENSAGEM COMO PARÂMETRO.
//
// Esse método é o "contrato" que todos os canais compartilham — a interface.
// Quem implementa decide COMO enviar (SMS por operadora, e-mail por SMTP...),
// mas TODOS prometem receber a mensagem e fazer algo com ela.
//
// O segundo método (getNome) é o bônus: devolve o nome do canal, igual
// você fez no Exercicio15 — serve pra mostrar QUAL canal está agindo.

public interface ServicoMensagem {

    // COMPLETAR: declare o método enviar, que recebe um String chamado
    // "mensagem" e não devolve nada. (Sem corpo — termina em ";")
    // Dica: void enviar(String mensagem);
    void enviar(String mensagem);


    // COMPLETAR: declare o método getNome, que devolve um String
    // com o nome do canal ("SMS", "E-mail"...).
    // Dica: String getNome();
    String getNome();

}
