public class MaquinaDeBanho {

    // Regras (litros):
    //   Água: no máximo 30   | Shampoo: no máximo 10
    //   Cada banho consome 10 de água e 2 de shampoo
    //   Cada limpeza consome 3 de água e 1 de shampoo
    //   Cada abastecimento coloca 2 litros

    // Estado da máquina (private: só a classe mexe direto)
    private int agua;             // litros de água na máquina
    private int shampoo;          // litros de shampoo na máquina
    private boolean temPet;       // tem pet dentro?
    private boolean petLimpo;     // o pet atual já tomou banho?
    private boolean maquinaSuja;  // precisa limpar antes do próximo pet?

    // Começa vazia, sem pet e limpa
    public MaquinaDeBanho() {
        agua = 0;
        shampoo = 0;
        temPet = false;
        petLimpo = false;
        maquinaSuja = false;
    }

    // Só pode 1 pet por vez, e a máquina precisa estar limpa
    public void colocarPet() {
        if (temPet) {
            System.out.println("A máquina já tem um pet!");
            return;
        }
        if (maquinaSuja) {
            System.out.println("A máquina está suja! Limpe antes de colocar outro pet.");
            return;
        }
        temPet = true;
        petLimpo = false;
        System.out.println("Pet colocado na máquina.");
    }

    // Retira o pet; se ele sair sujo, a máquina fica suja
    public void retirarPet() {
        if (!temPet) {
            System.out.println("Não há pet na máquina.");
            return;
        }
        if (______) {
            maquinaSuja = true;
            System.out.println("O pet saiu sujo! A máquina precisa de limpeza.");
        } else {
            System.out.println("Pet retirado, limpinho!");
        }
        temPet = false;
    }

    // Informa se tem pet dentro da máquina
    public void verificarPet() {
        if (temPet) {
            System.out.println("Tem um pet na máquina.");
        } else {
            System.out.println("A máquina está vazia.");
        }
    }
}
