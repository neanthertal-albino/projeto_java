// Meia ENTRADA: herda tudo de Ingresso, mas o valor é SEMPRE metade.
// Palavra-chave "extends" = herança. MeiaEntrada É UM Ingresso.

public class MeiaEntrada extends Ingresso {

    // Construtor: recebe os 3 dados e repassa para a superclasse com "super".
    // super(...) chama o construtor da classe pai (Ingresso).
    public MeiaEntrada(String nomeFilme, double valor, boolean dublado) {
        super(nomeFilme, valor, dublado);
    }

    // Aqui está o POLIMORFISMO: mesmo nome do método da base,
    // mas com o comportamento diferente (metade do valor).
    // O @Override avisa: "estou sobrescrevendo o método do pai".
    @Override
    public double calcularValor() {
        // COMPLETAR: devolva metade do valor.
        // Dica: use getValor() (herdado da base) dividido por 2.
        return getValor()/2;
    }
}
