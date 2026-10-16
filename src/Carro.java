public class Carro {

    // Estado do carro (campo private: só a classe mexe direto neles)
    private boolean ligado;
    private int marcha;      // 0 = ponto morto, 1 a 6
    private int velocidade;  // km/h

    // Ao ser criado: desligado, em ponto morto e velocidade 0
    public Carro() {
        ligado = ________;
        marcha = ________;
        velocidade = ________;
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
        if (marcha ______ 0 || velocidade ______ 0) {
            System.out.println("Não é possível desligar!");
            System.out.println("Ponha em ponto morto e zere a velocidade primeiro.");
            return;
        }
        ligado = false;
        System.out.println("Carro desligado.");
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
