// =============================================
// EXERCÍCIO: STREAM API
// =============================================
// Objetivo: Trabal with Lists, filter, map, sorted, collect
// Dica: streams permitem "o que fazer" ao invés "como fazer"
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExercicioStreams {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Amanda");
        nomes.add("Carlos");
        nomes.add("Bianca");
        nomes.add("Diego");
        
        // 1) Filtrar nomes que começam com "A" e imprimir cada um
        // Dica: nomes.stream().filter(n -> n.startsWith("A")).forEach(System.out::println);
        System.out.println("=== Nomes com A ===");
        nomes.stream()
             .filter(n -> n.startsWith("A"))
             .forEach(System.out::println);
        
        // 2) Transformar TODOS os nomes para MAIÚSCULO e coletar numa nova lista
        // Dica: .map(String::toUpperCase)
        List<String> nomesMaiusculos = nomes.stream()
             .map(String::toUpperCase)
             .collect(Collectors.toList());
        System.out.println("\n=== Nomes maiúsculos ===");
        System.out.println(nomesMaiusculos);
        
        // 3) Filtrar nomes com mais de 4 letras, ordenar e imprimir
        // Dica: .filter(n -> n.length() > 4).sorted()
        System.out.println("\n=== Mais de 4 letras (ordenados) ===");
        nomes.stream()
             .filter(n -> n.length() > 4)
             .sorted()
             .forEach(System.out::println);
    }
}
