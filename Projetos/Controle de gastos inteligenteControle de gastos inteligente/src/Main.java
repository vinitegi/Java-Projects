import service.ImportadorCsvService;
import service.DetectorRecorrenciaService;
import service.ExportadorCsvService;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Path> arquivosCsv = new ArrayList<>();

        ImportadorCsvService importador = new ImportadorCsvService();
        DetectorRecorrenciaService detector = new DetectorRecorrenciaService();
        ExportadorCsvService exportador = new ExportadorCsvService();

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Inserir arquivos CSV");
            System.out.println("2 - Gerar relatório de gastos recorrentes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpa buffer

            switch (opcao) {
                case 1 -> inserirArquivos(sc, arquivosCsv);
                case 2 -> gerarRelatorio(arquivosCsv, importador, detector, exportador);
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    private static void inserirArquivos(Scanner sc, List<Path> arquivosCsv) {

        String resposta;

        do {
            System.out.print("Digite o nome do arquivo CSV: ");
            String nomeArquivo = sc.nextLine();

            arquivosCsv.add(Path.of(nomeArquivo));

            System.out.print("Deseja inserir outro arquivo? (S/N): ");
            resposta = sc.nextLine().trim().toUpperCase();

        } while (resposta.equals("S"));

        System.out.println("Arquivos adicionados com sucesso!");
    }

    private static void gerarRelatorio(
            List<Path> arquivosCsv,
            ImportadorCsvService importador,
            DetectorRecorrenciaService detector,
            ExportadorCsvService exportador
    ) {

        if (arquivosCsv.isEmpty()) {
            System.out.println("Nenhum arquivo CSV foi inserido.");
            return;
        }

        var transacoes = importador.importar(arquivosCsv);
        var recorrentes = detector.detectar(transacoes);

        exportador.exportar(recorrentes, "relatorio-recorrentes.csv");

        System.out.println("Relatório gerado com sucesso: relatorio-recorrentes.csv");
    }
}
