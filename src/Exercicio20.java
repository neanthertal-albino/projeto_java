// =============================================
// EXERCÍCIO 20 — Gerador de JSON, XML e YAML
// =============================================
// O usuário digita vários campos no formato:
//
//     NOME_CAMPO;VALOR;TIPO;
//
// Exemplo:
//     nome;Lucas;texto;
//     idade;25;inteiro;
//     altura;1.75;decimal;
//     nascimento;15/10/2000;data;
//     cadastro;15/10/2000 14:30:00;data e hora;
//     ativo;true;booleano;
//     tags;java|poo|dio;array de texto;
//
// Quando ele digitar "sair" (ou deixar a linha vazia), o programa
// imprime os mesmos dados em JSON, XML e YAML.
//
// Separadores usados:
//   ;  -> separa nome, valor e tipo (é o "caractere escolhido")
//   |  -> separa os itens dentro de um array
//
// Tipos aceitos:
//   texto, data, data e hora, inteiro, decimal, booleano
//   e as versões array: "array de texto", "array de inteiro", etc.
//
// OPCIONAL (fica como desafio):
//   - arrays de objetos e objetos internos. Uma ideia seria aceitar nomes
//     com ponto (ex.: endereco.rua;Rua X;texto) e montar um objeto aninhado.
//   - ler os campos de um arquivo .txt em vez do teclado.

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio20 {

    private static final String SEPARADOR_CAMPOS = ";";
    private static final String SEPARADOR_ARRAY = "|";
    private static final String PREFIXO_ARRAY = "array de ";

    // Formatadores de data. O "uuuu" (ano) junto com STRICT impede datas
    // impossíveis, tipo 31/02/2026.
    private static final DateTimeFormatter FORMATO_DATA =
            DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
    private static final DateTimeFormatter FORMATO_DATA_HORA =
            DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss").withResolverStyle(ResolverStyle.STRICT);

    // Classe simples que guarda um campo já validado.
    static class Campo {
        String nome;
        String valor;
        String tipo;

        Campo(String nome, String valor, String tipo) {
            this.nome = nome;
            this.valor = valor;
            this.tipo = tipo;
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Campo> campos = new ArrayList<>();

        System.out.println("=== Gerador de JSON / XML / YAML ===");
        System.out.println("Formato: NOME_CAMPO" + SEPARADOR_CAMPOS
                + "VALOR" + SEPARADOR_CAMPOS + "TIPO" + SEPARADOR_CAMPOS);
        System.out.println("Tipos: texto, data, data e hora, inteiro, decimal, booleano");
        System.out.println("Arrays: array de texto, array de inteiro, ...");
        System.out.println("Em arrays, separe os itens com " + SEPARADOR_ARRAY);
        System.out.println("Digite 'sair' (ou deixe vazio) para gerar a saída.\n");

        while (true) {
            System.out.print("> ");
            String linha = leitor.nextLine().trim();

            if (linha.isEmpty() || linha.equalsIgnoreCase("sair")) {
                break;
            }

            // O split(";") em "nome;Lucas;texto;" devolve 3 pedaços
            // (o ";" do final é descartado pelo próprio split).
            String[] partes = linha.split(SEPARADOR_CAMPOS);

            if (partes.length != 3) {
                System.out.println("  Erro: use NOME_CAMPO" + SEPARADOR_CAMPOS
                        + "VALOR" + SEPARADOR_CAMPOS + "TIPO" + SEPARADOR_CAMPOS);
                continue;
            }

            String nome = partes[0].trim();
            String valor = partes[1].trim();
            String tipo = normalizarTipo(partes[2]);

            if (nome.isEmpty()) {
                System.out.println("  Erro: o nome do campo não pode ficar vazio.");
                continue;
            }
            if (tipo == null) {
                System.out.println("  Erro: tipo desconhecido '" + partes[2].trim() + "'.");
                continue;
            }
            if (!valorValido(valor, tipo)) {
                System.out.println("  Erro: o valor '" + valor + "' não é um " + tipo + " válido.");
                continue;
            }

            campos.add(new Campo(nome, valor, tipo));
            System.out.println("  ok: " + nome + " (" + tipo + ")");
        }

        leitor.close();

        System.out.println("\n========== JSON ==========");
        System.out.println(gerarJson(campos));

        System.out.println("\n========== XML ==========");
        System.out.println(gerarXml(campos));

        System.out.println("\n========== YAML ==========");
        System.out.println(gerarYaml(campos));
    }

    // ---------------------------------------------------------------
    // TIPO
    // ---------------------------------------------------------------

    // Devolve o tipo padronizado ("array de texto", "inteiro"...)
    // ou null se o tipo não existir.
    static String normalizarTipo(String bruto) {
        String t = bruto.trim().toLowerCase();
        t = t.replace("_", " ").replace("-", " ");
        t = t.replaceAll("\\s+", " ").trim();

        boolean ehArray = false;
        String base = t;

        if (t.startsWith(PREFIXO_ARRAY)) {
            ehArray = true;
            base = t.substring(PREFIXO_ARRAY.length()).trim();
        } else if (t.startsWith("array ")) {
            ehArray = true;
            base = t.substring("array ".length()).trim();
        }

        String tipoBase = normalizarTipoBase(base);
        if (tipoBase == null) {
            return null;
        }
        return ehArray ? PREFIXO_ARRAY + tipoBase : tipoBase;
    }

    static String normalizarTipoBase(String t) {
        switch (t) {
            case "texto":
            case "string":
            case "text":
                return "texto";
            case "data":
            case "date":
                return "data";
            case "data e hora":
            case "data hora":
            case "datahora":
            case "datetime":
                return "data e hora";
            case "inteiro":
            case "int":
            case "long":
            case "numero inteiro":
            case "número inteiro":
                return "inteiro";
            case "decimal":
            case "flutuante":
            case "double":
            case "float":
            case "numero decimal":
            case "número decimal":
            case "numero com ponto flutuante":
            case "número com ponto flutuante":
                return "decimal";
            case "booleano":
            case "boolean":
            case "bool":
                return "booleano";
            default:
                return null;
        }
    }

    // ---------------------------------------------------------------
    // VALIDAÇÃO
    // ---------------------------------------------------------------

    static boolean valorValido(String valor, String tipo) {
        if (tipo.equals("texto")) {
            return true; // qualquer texto serve, até vazio
        }
        if (tipo.equals("inteiro")) {
            return converterInteiro(valor) != null;
        }
        if (tipo.equals("decimal")) {
            return converterDecimal(valor) != null;
        }
        if (tipo.equals("booleano")) {
            return valor.equalsIgnoreCase("true") || valor.equalsIgnoreCase("false");
        }
        if (tipo.equals("data")) {
            return converterData(valor) != null;
        }
        if (tipo.equals("data e hora")) {
            return converterDataHora(valor) != null;
        }
        if (tipo.startsWith(PREFIXO_ARRAY)) {
            String base = tipo.substring(PREFIXO_ARRAY.length());
            if (valor.isEmpty()) {
                return true; // array vazio é permitido
            }
            for (String item : valor.split("\\" + SEPARADOR_ARRAY, -1)) {
                if (item.trim().isEmpty() || !valorValido(item.trim(), base)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    static Long converterInteiro(String valor) {
        if (!valor.trim().matches("[+-]?\\d+")) {
            return null;
        }
        try {
            return Long.parseLong(valor.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    static Double converterDecimal(String valor) {
        try {
            // aceita vírgula ou ponto como separador decimal: "1,75" ou "1.75"
            Double numero = Double.parseDouble(valor.trim().replace(",", "."));
            return Double.isFinite(numero) ? numero : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    static LocalDate converterData(String valor) {
        try {
            return LocalDate.parse(valor.trim(), FORMATO_DATA);
        } catch (Exception e) {
            return null;
        }
    }

    static LocalDateTime converterDataHora(String valor) {
        try {
            return LocalDateTime.parse(valor.trim(), FORMATO_DATA_HORA);
        } catch (Exception e) {
            return null;
        }
    }

    // Separa os itens de um array e já tira os espaços sobrando.
    static List<String> itensDoArray(String valor) {
        List<String> itens = new ArrayList<>();
        if (valor.trim().isEmpty()) {
            return itens;
        }
        for (String item : valor.split("\\" + SEPARADOR_ARRAY, -1)) {
            itens.add(item.trim());
        }
        return itens;
    }

    // ---------------------------------------------------------------
    // JSON
    // ---------------------------------------------------------------

    static String gerarJson(List<Campo> campos) {
        if (campos.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{\n");
        for (int i = 0; i < campos.size(); i++) {
            Campo c = campos.get(i);
            sb.append("  \"").append(escaparJson(c.nome)).append("\": ");
            sb.append(valorJson(c.valor, c.tipo));
            if (i < campos.size() - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    static String valorJson(String valor, String tipo) {
        if (tipo.equals("texto") || tipo.equals("data") || tipo.equals("data e hora")) {
            return "\"" + escaparJson(valor) + "\"";
        }
        if (tipo.equals("inteiro")) {
            return String.valueOf(converterInteiro(valor));
        }
        if (tipo.equals("decimal")) {
            return String.valueOf(converterDecimal(valor));
        }
        if (tipo.equals("booleano")) {
            return valor.toLowerCase();
        }
        if (tipo.startsWith(PREFIXO_ARRAY)) {
            String base = tipo.substring(PREFIXO_ARRAY.length());
            List<String> itens = itensDoArray(valor);
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < itens.size(); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(valorJson(itens.get(i), base));
            }
            sb.append("]");
            return sb.toString();
        }
        return "\"" + escaparJson(valor) + "\"";
    }

    static String escaparJson(String texto) {
        return texto.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    // ---------------------------------------------------------------
    // XML
    // ---------------------------------------------------------------

    static String gerarXml(List<Campo> campos) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<registros>\n");

        for (Campo c : campos) {
            String nome = escaparXml(c.nome);
            String tipo = escaparXml(c.tipo);

            if (c.tipo.startsWith(PREFIXO_ARRAY)) {
                List<String> itens = itensDoArray(c.valor);
                if (itens.isEmpty()) {
                    sb.append("  <campo nome=\"").append(nome)
                            .append("\" tipo=\"").append(tipo).append("\" />\n");
                } else {
                    sb.append("  <campo nome=\"").append(nome)
                            .append("\" tipo=\"").append(tipo).append("\">\n");
                    for (String item : itens) {
                        sb.append("    <item>").append(escaparXml(item)).append("</item>\n");
                    }
                    sb.append("  </campo>\n");
                }
            } else {
                sb.append("  <campo nome=\"").append(nome)
                        .append("\" tipo=\"").append(tipo).append("\">")
                        .append(escaparXml(c.valor)).append("</campo>\n");
            }
        }

        sb.append("</registros>");
        return sb.toString();
    }

    static String escaparXml(String texto) {
        return texto.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }

    // ---------------------------------------------------------------
    // YAML
    // ---------------------------------------------------------------

    static String gerarYaml(List<Campo> campos) {
        if (campos.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();

        for (Campo c : campos) {
            String chave = chaveYaml(c.nome);

            if (c.tipo.startsWith(PREFIXO_ARRAY)) {
                String base = c.tipo.substring(PREFIXO_ARRAY.length());
                List<String> itens = itensDoArray(c.valor);
                if (itens.isEmpty()) {
                    sb.append(chave).append(": []\n");
                } else {
                    sb.append(chave).append(":\n");
                    for (String item : itens) {
                        sb.append("  - ").append(valorYaml(item, base)).append("\n");
                    }
                }
            } else {
                sb.append(chave).append(": ").append(valorYaml(c.valor, c.tipo)).append("\n");
            }
        }

        // tira o último \n para o println não deixar uma linha em branco
        return sb.substring(0, sb.length() - 1);
    }

    static String valorYaml(String valor, String tipo) {
        if (tipo.equals("texto") || tipo.equals("data") || tipo.equals("data e hora")) {
            return "\"" + escaparYaml(valor) + "\"";
        }
        if (tipo.equals("inteiro")) {
            return String.valueOf(converterInteiro(valor));
        }
        if (tipo.equals("decimal")) {
            return String.valueOf(converterDecimal(valor));
        }
        if (tipo.equals("booleano")) {
            return valor.toLowerCase();
        }
        return "\"" + escaparYaml(valor) + "\"";
    }

    // Chaves simples podem ficar sem aspas; as "esquisitas" ganham aspas.
    static String chaveYaml(String nome) {
        if (nome.matches("[A-Za-z0-9_.-]+")) {
            return nome;
        }
        return "\"" + escaparYaml(nome) + "\"";
    }

    static String escaparYaml(String texto) {
        return texto.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}
