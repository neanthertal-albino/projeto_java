// QUADRADO — implementação de FormaGeometrica.
// Este arquivo vem PRONTO: é o seu gabarito de modelo.
// Tem UM atributo (lado) e a área é lado * lado.

public class Quadrado implements FormaGeometrica {

    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    // O contrato promete DEVOLVER a área — por isso tem "return".
    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public String getNome() {
        return "Quadrado";
    }
}
