// =============================================
// EXERCÍCIO: GENERICS - Caixa Genérica
// =============================================
// Objetivo: Criar uma classe genérica que guarda UM objeto do tipo T.
// Depois você consegue reutilizar essa mesma classe para String, Integer, Produto, etc.
// Dica: <T> significa "Tipo Genérico"

// 1) Declare a classe Caixa como genérica
public class Caixa<T> {
    
    // 2) Crie um atributo privado do tipo T chamado "item"
    private T item;
    
    // 3) Crie um construtor que recebe um item do tipo T e atribui ao atributo
    public Caixa (T item) {
        this.item = item;
    }
    
    // 4) Crie um método getItem() que retorna o item do tipo T
    public T getItem() {
        return item;
    }
    
    // 5) Crie um método exibir() que imprime: "Item: " + item
    public void exibir() {
        System.out.println("Item: " + item);
    }
}
