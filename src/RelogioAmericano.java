// Relógio AMERICANO: formato 12 horas.
// Para ele NÃO existem horas de 13 até 24 — a faixa vai de 1 a 12.

public class RelogioAmericano extends Relogio {
    // Sobrescrevemos setHora para aceitar SÓ de 1 a 12.
    // (Repare: estamos sobrescrevendo um método que foi herdado da base.)
    @Override
    public void setHora(int hora) {
        // COMPLETAR: aceite apenas valores de 1 a 12; fora disso, avise.
        // Dica: depois de validar, chame super.setHora(hora) para gravar
        // o valor no campo que está lá na classe pai.
        if (hora >= 1 && hora <= 12) {
            super.setHora(hora);
        } else {
            System.out.printf("Na unidade estadunidense não existe hora %s", hora);
        }
    }

    // Implementação obrigatória do método abstrato.
    @Override
    public void sincronizar(Relogio outro) {
        // O relógio de origem pode estar em 24h. Precisamos converter para 12h.
        // Regra de conversão:
        //   - se a hora do outro for MAIOR que 12 -> subtraia 12
        //   - se a hora do outro for 0               -> vira 12
        //   - caso contrário                         -> mantém a hora do outro
        // COMPLETAR:
        int h = outro.getHora();
        //   ... ajuste o h conforme a regra ...

        if (h > 12) {
            h -= 12;
            System.out.printf("Na unidade estadunidense não existe hora %s", h);
        } else if (h == 0) {
            h = 12;
        }

        setHora(h);                       // grava a hora convertida
        setMinuto(outro.getMinuto());     // minuto e segundo copiam direto
        setSegundo(outro.getSegundo());
    }
}
