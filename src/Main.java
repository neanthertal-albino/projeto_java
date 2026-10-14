import util.Mensagem;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // String e System ja funcionam sem import (java.lang e automatico)

        List<String> linguagens = List.of("Python", "JavaScript", "Java");
        linguagens.forEach(l -> System.out.println(l));

        System.out.println(Mensagem.formatar("Primeiro projeto em Java!"));
    }
}
