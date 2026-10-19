// EXERCÍCIO 15 — Testando a interface FormaPagamento.
// Crie as três formas de pagamento, pague a mesma conta com cada uma
// e descubra o "pulo do gato" da interface: variável do TIPO da interface.

public class Exercicio15 {
    public static void main(String[] args) {

        double conta = 120.50;

        // ---- 1) Criar as três formas de pagamento ----
        // COMPLETAR: crie um Pix com a chave "ana@email.com" (variável: pix)
        // COMPLETAR: crie um CartaoCredito parcelado em 3 vezes (variável: cartao)
        // COMPLETAR: crie um Dinheiro entregando 150.00 (variável: dinheiro)
        Pix pix = new Pix("ana@email.com");
        CartaoCredito cartao = new CartaoCredito(3);
        Dinheiro dinheiro = new Dinheiro(100);
        


        // ---- 2) Pagar a mesma conta com cada uma (chamada direta) ----
        pix.pagar(conta);
        cartao.pagar(conta);
        dinheiro.pagar(conta);

        // COMPLETAR: chame cartao.pagar(conta) e dinheiro.pagar(conta)
        System.out.println();

        // ---- 3) O PULO DO GATO: variável do tipo da INTERFACE ----
        // Uma variável FormaPagamento pode guardar QUALQUER implementação.
        // A mesma variável muda de "conteúdo" e o Java descobre na hora
        // QUAL pagar() executar — é o polimorfismo pela interface!
        
        FormaPagamento forma = pix;
        forma.pagar(conta);
        System.out.println("Usando: " + forma.getNome());

        forma = cartao;
        forma.pagar(conta);
        System.out.println("Usando: " + forma.getNome());

        forma = dinheiro;
        forma.pagar(conta);
        System.out.println("Usando: " + forma.getNome());



        // COMPLETAR: reaproveite a variável 'forma' para apontar pro cartao,
        // depois pro dinheiro. Chame pagar() e getNome() em cada caso.
        // (É só atribuir: forma = cartao;  e repetir as duas linhas.)


        System.out.println();

        // ---- 4) BÔNUS: array do tipo da interface + for ----
        // Ele guarda as três implementações juntas (todas "são" FormaPagamento).
        FormaPagamento[] formas = { pix, cartao, dinheiro };

        
        for (int i = 0; i < formas.length; i++) {
            System.out.println("Usando: " + formas[i].getNome());
            formas[i].pagar(conta);
        }

        // COMPLETAR: um for que percorre o array e, para cada item,
        // imprime o nome e chama pagar(conta).
        // Lembrete: formas.length e formas[i]


        // ---- 5) Teste de erro ----
        // Tente criar "new FormaPagamento();" e veja o erro do compilador:
        // interface não é molde de objeto, é só contrato. Depois desfaça.
    }
}
