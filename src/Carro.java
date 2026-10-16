public class Carro {

    // Estado do carro (campo private: só a classe mexe direto neles)
    private boolean ligado;
    private int marcha;      // 0 = ponto morto, 1 a 6
    private int velocidade;  // km/h

    // Ao ser criado: desligado, em ponto morto e velocidade 0
    public Carro() {
        ligado = false;
        marcha = 0;
        velocidade = 0;
    }

    public void ligar() {
        if (ligado) {
            System.out.println("O carro já está ligado.");
            return; // sai do método sem fazer mais nada
        }
        ligado = true;
        System.out.println("Carro ligado! Ponto morto, velocidade 0.");
    }

    // Só desliga se estiver em ponto morto E velocidade 0
    public void desligar() {
        if (!ligado) {
            System.out.println("O carro já está desligado.");
            return;
        }
        if (marcha != 0 || velocidade != 0) {
            System.out.println("Não é possível desligar!");
            System.out.println("Ponha em ponto morto e zere a velocidade primeiro.");
            return;
        }
        ligado = false;
        System.out.println("Carro desligado.");
    }

    // Sobe ou desce UMA marcha por vez (0 = ponto morto, até 6)
    public void trocarMarcha(int novaMarcha) {
        if (!ligado) {
            System.out.println("O carro está desligado. Ligue-o primeiro.");
            return;
        }
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida! O carro tem marchas 0 a 6.");
            return;
        }
        int diferenca = novaMarcha - marcha;
        if (diferenca > 1 || diferenca < -1) {
            System.out.println("Não é permitido pular marcha!");
            return;
        }
        marcha = novaMarcha;
        System.out.println("Agora está na marcha: " + marcha);
    }

    // Auxiliar: limite MÁXIMO da marcha atual (1ª: 20, 2ª: 40, ... 6ª: 120)
    private int limiteSuperior() {
        return marcha * 20;
    }

    // Auxiliar: limite MÍNIMO da marcha atual (1ª: 0, 2ª: 21, 3ª: 41, ...)
    private int limiteInferior() {
        if (marcha <= 1) {
            return 0;
        }
        return (marcha - 1) * 20 + 1;
    }

    // Aumenta 1 km/h respeitando o limite da marcha atual
    public void acelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado. Ligue-o primeiro.");
            return;
        }
        if (marcha == 0) {
            System.out.println("Em ponto morto não é possível acelerar!");
            return;
        }
        int novaVelocidade = velocidade + 1;
        if (novaVelocidade > limiteSuperior()) {
            System.out.println("Velocidade máxima da marcha " + marcha + " atingida!");
            return;
        }
        velocidade = novaVelocidade;
        System.out.println("Velocidade: " + velocidade + " km/h");
    }

    // Diminui 1 km/h respeitando o limite da marcha atual
    public void diminuir() {
        if (!ligado) {
            System.out.println("O carro está desligado. Ligue-o primeiro.");
            return;
        }
        if (velocidade == 0) {
            System.out.println("A velocidade já é 0.");
            return;
        }
        int novaVelocidade = velocidade - 1;
        if (novaVelocidade < limiteInferior()) {
            System.out.println("Velocidade mínima da marcha " + marcha + "! Reduza a marcha primeiro.");
            return;
        }
        velocidade = novaVelocidade;
        System.out.println("Velocidade: " + velocidade + " km/h");
    }

    // Mostra a velocidade atual (desligado não pode fazer nada)
    public void verificarVelocidade() {
        if (!ligado) {
            System.out.println("O carro está desligado. Ligue-o primeiro.");
            return;
        }
        System.out.println("Velocidade: " + velocidade + " km/h");
    }
}
