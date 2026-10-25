// =============================================
// EXERCÍCIO 19 — Formatador de telefones
// =============================================
// Regras:
//   FIXO     -> 8 dígitos:   xxxx-xxxx
//               10 dígitos:  (xx)xxxx-xxxx   (2 de DDD + 8)
//   CELULAR  -> 9 dígitos:   xxxxx-xxxx
//               11 dígitos:  (xx)xxxxx-xxxx  (2 de DDD + 9)
//
// O programa deve:
//   - só números           -> detectar o tipo e formatar;
//   - quantidade errada    -> dizer que é inválido;
//   - já formatado         -> devolver igual e dizer o tipo;
//   - máscara errada       -> corrigir e devolver;
//   - letras/símbolos      -> extrair os números e tentar; se não der, inválido.
//
// PULO DO GATO (já pronto embaixo): apenasDigitos()
//   entrada.replaceAll("\\D", "")
//   "\\D" = "qualquer coisa que NÃO seja dígito" (espaço, parêntese, traço,
//   letra, ponto...). Trocar tudo isso por "" deixa só os números.
//   Com isso os 5 casos viram um só: extrair os dígitos e olhar o tamanho.
//
// Depois de ter `digitos`:
//   tamanho 8 ou 10  -> FIXO
//   tamanho 9 ou 11  -> CELULAR
//   qualquer outro   -> INVÁLIDO
//
// Formatado, a partir de `digitos`:
//   8  -> digitos.substring(0,4)  + "-" + digitos.substring(4)
//   9  -> digitos.substring(0,5)  + "-" + digitos.substring(5)
//   10 -> "(" + substring(0,2) + ")" + substring(2,6) + "-" + substring(6)
//   11 -> "(" + substring(0,2) + ")" + substring(2,7) + "-" + substring(7)
//   (substring(inicio, fim) pega do inicio até ANTES do fim)

import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um telefone (com ou sem formatação):");
        String entrada = leitor.nextLine();

        String digitos = apenasDigitos(entrada);

        String tipo = descobrirTipo(digitos);

        if (tipo.equals("INVÁLIDO")) {
            System.out.println("Entrada inválida: não corresponde a nenhum formato aceito.");
            leitor.close();
            return;
        }

        String formatado = formatar(digitos);

        String entradaSemEspacos = entrada.replaceAll("\\s", "");
        if (entradaSemEspacos.equals(formatado)) {
            System.out.println("O telefone já estava formatado.");
        } else {
            System.out.println("Telefone formatado/corrigido.");
        }

        System.out.println("Tipo: " + tipo);
        System.out.println("Telefone: " + formatado);

        leitor.close();
    }

    // Já pronto: deixa só os dígitos da entrada (tira espaço, (), -, letras...)
    static String apenasDigitos(String texto) {
        return texto.replaceAll("\\D", "");
    }

    // TODO: completar
    // 8 ou 10  -> "Telefone fixo"
    // 9 ou 11  -> "Celular"
    // senão    -> "INVÁLIDO"
    static String descobrirTipo(String digitos) {
        if (digitos.length() == 8 || digitos.length() == 10) {
            return "Telefone fixo";
        } else if (digitos.length() == 9 || digitos.length() == 11) {
            return "Celular";
        } else {
            return "INVÁLIDO";
        }
    }

    static String formatar(String digitos) {
        if (digitos.length() == 8) {
            return digitos.substring(0, 4) + "-" + digitos.substring(4);
        } else if (digitos.length() == 9) {
            return digitos.substring(0, 5) + "-" + digitos.substring(5);
        } else if (digitos.length() == 10) {
            return "(" + digitos.substring(0, 2) + ")" + digitos.substring(2, 6)
                    + "-" + digitos.substring(6);
        } else if (digitos.length() == 11) {
            return "(" + digitos.substring(0, 2) + ")" + digitos.substring(2, 7)
                    + "-" + digitos.substring(7);
        } else {
            return "";
        }
    }
}
