import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OrganizandoEstoque {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String entrada = scanner.nextLine();
        String saida = organizarEstoque(entrada);

        System.out.println(saida);

        scanner.close();
    }

    public static String organizarEstoque(String entrada) {
        // Cria um mapa para armazenar os totais mantendo a ordem
        Map<String, Integer> mapa = new LinkedHashMap<>();

        String[] lojas = entrada.split(",");

        for (String loja : lojas) {
            String[] partes = loja.split(":");
            String codigo = partes[0].trim();
            int quantidade = Integer.parseInt(partes[1].trim());

            // Atualiza a quantidade no mapa
            mapa.put(codigo, mapa.getOrDefault(codigo, 0) + quantidade);
        }

        StringBuilder sb = new StringBuilder();

        // Itera no mapa e monta a string de saída
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1); // remove a última vírgula
        }

        return sb.toString();
    }
}

