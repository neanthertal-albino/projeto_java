// Relógio BRASILEIRO: formato 24 horas (0 a 23).
// Ele NÃO precisa mudar as regras da base — usa os setters que já existem.

public class RelogioBrasileiro extends Relogio {

    // Implementação obrigatória do método abstrato.
    @Override
    public void sincronizar(Relogio outro) {
        // Como o brasileiro já trabalha em 24h, basta COPIAR os valores
        // do outro relógio para este.
        // COMPLETAR: use os setters deste relógio com os getters do "outro":
        setHora(outro.getHora());
        setMinuto(outro.getMinuto());
        setSegundo(outro.getSegundo());
    }
}
