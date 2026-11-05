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
        if (!petLimpo) {
            maquinaSuja = true;
            System.out.println("O pet saiu sujo! A máquina precisa de limpeza.");
        } else {
            System.out.println("Pet retirado, limpinho!");
        }
        temPet = false;
    }

    // Coloca 2 litros de água, respeitando o máximo
    public void abastecerAgua() {
        int recarga = 2; // cada abastecimento coloca 2 litros
        if (agua + recarga > 30) {
            System.out.println("A água já está no nível máximo!");
            return;
        }
        agua = agua + recarga;
        System.out.println("Água abastecida. Nível atual: " + agua + " litros.");
    }

    // Coloca 2 litros de shampoo, respeitando o máximo
    public void abastecerShampoo() {
        int recarga = 2;
        if (shampoo + recarga > 10) {
            System.out.println("O shampoo já está no nível máximo!");
            return;
        }
        shampoo = shampoo + recarga;
        System.out.println("Shampoo abastecido. Nível atual: " + shampoo + " litros.");
    }

    public void verificarNivelAgua() {
        System.out.println("Nível de água: " + agua + " litros (máximo 30).");
    }

    public void verificarNivelShampoo() {
        System.out.println("Nível de shampoo: " + shampoo + " litros (máximo 10).");
    }

    // Dá banho no pet: consome 10 de água e 2 de shampoo
    public void darBanho() {
        if (!temPet) {
            System.out.println("Não tem pet na máquina!");
            return;
        }
        if (petLimpo) {
            System.out.println("Esse pet já está limpo!");
            return;
        }
        if (agua < 10) {
            System.out.println("Água insuficiente! Abasteça a máquina.");
            return;
        }
        if (shampoo < 2) {
            System.out.println("Shampoo insuficiente! Abasteça a máquina.");
            return;
        }
        agua = agua - 10;
        shampoo = shampoo - 2;
        petLimpo = true;
        System.out.println("Banho realizado! Pet limpinho.");
    }

    // Limpa a máquina: consome 3 de água e 1 de shampoo
    public void limparMaquina() {
        if (agua < 3 || shampoo < 1) {
            System.out.println("Sem água ou shampoo suficientes para limpar!");
            return;
        }
        agua = agua - 3;
        shampoo = shampoo - 1;
        maquinaSuja = false;
        System.out.println("Máquina limpa!");
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
