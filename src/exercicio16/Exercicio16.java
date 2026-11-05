// EXERCÍCIO 16 — Marketing multicanal com INTERFACE.
// A MESMA mensagem de marketing vai para canais diferentes.
// Repare que é a mesma estrutura do Exercicio15, só mudou o cenário:
// interface ServicoMensagem no lugar de FormaPagamento.

public class Exercicio16 {
    public static void main(String[] args) {

        // A campanha: uma única mensagem que vale para todos os canais.
        String campanha = "20% de desconto so HOJE! Corre pra nao perder: dio.me";

        // ---- 1) Criar os quatro serviços ----
        SMS sms = new SMS("(11) 98888-7777");
        Email email = new Email("ana@email.com");
        RedesSociais redes = new RedesSociais("@ana.dev");
        WhatsApp zap = new WhatsApp("(11) 97777-6666");
        // COMPLETAR: crie um Email para "ana@email.com" (variável: email)
        // COMPLETAR: crie uma RedesSociais para "@ana.dev" (variável: redes)
        // COMPLETAR: crie um WhatsApp para "(11) 97777-6666" (variável: zap)

        // ---- 2) Enviar a MESMA mensagem para cada serviço (chamada direta) ----
        sms.enviar(campanha);
        email.enviar(campanha);
        redes.enviar(campanha);
        zap.enviar(campanha);

        // COMPLETAR: chame email.enviar(campanha), redes.enviar(campanha)
        //           e zap.enviar(campanha)
        System.out.println();

        // ---- 3) O PULO DO GATO: variável do tipo da INTERFACE ----
        // A mesma variável muda de conteúdo e o Java descobre na hora
        // qual enviar() executar — polimorfismo via contrato!
        ServicoMensagem canal = sms;
        canal.enviar(campanha);
        System.out.println("Canal: " + canal.getNome());
        canal = email;
        canal.enviar(campanha);
        System.out.println("E-mail: " + canal.getNome());
        canal = redes;
        canal.enviar(campanha);
        System.out.println("Rede social: " + canal.getNome());
        canal = zap;
        canal.enviar(campanha);
        System.out.println("WhatsApp: " + canal.getNome());

        // COMPLETAR: reaponte 'canal' pro email, depois pra redes, depois pro zap.
        //           Em cada caso, chame enviar(campanha) e getNome().
        System.out.println();

        // ---- 4) BÔNUS: array do tipo da interface + for ----
        ServicoMensagem[] canais = { sms, email, redes, zap };

        for (int i = 0; i < canais.length; i++) {
            System.out.println("Canal: " + canais[i].getNome());
            canais[i].enviar(campanha);
        }

        // COMPLETAR: um for que percorre o array e, para cada canal,
        // imprime o nome e envia a campanha.
        // Lembrete: canais.length e canais[i]

        // ---- 5) Teste de erro ----
        // Tente "new ServicoMensagem();" e veja o compilador recusar.
        // Interface é contrato, não molde de objeto. Depois desfaça.
    }
}
