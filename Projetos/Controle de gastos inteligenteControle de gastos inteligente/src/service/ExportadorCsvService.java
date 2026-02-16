package service;

import model.GastoRecorrente;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ExportadorCsvService {

    public void exportar(List<GastoRecorrente> gastos, String nomeArquivo) {

        Path caminho = Path.of(nomeArquivo);

        try (BufferedWriter writer = Files.newBufferedWriter(caminho)) {

            // Cabeçalho do CSV
            writer.write("Descricao,Categoria,ValorMedio,FrequenciaMensal,Inicio,Fim");
            writer.newLine();

            for (GastoRecorrente g : gastos) {
                writer.write(String.format(
                        "%s,%s,%s,%d,%s,%s",
                        g.getDescricaoNormalizada(),
                        g.getCategoria(),
                        g.getValorMedio(),
                        g.getFrequenciaMensal(),
                        g.getPrimeiraOcorrencia(),
                        g.getUltimaOcorrencia()
                ));
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar CSV", e);
        }
    }
}
