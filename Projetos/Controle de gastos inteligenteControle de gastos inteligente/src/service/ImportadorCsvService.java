package service;

import enums.Categoria;
import enums.TipoTransacao;
import model.Transacao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ImportadorCsvService {

    public List<Transacao> importar(List<Path> arquivos) {

        List<Transacao> transacoes = new ArrayList<>();

        for (Path arquivo : arquivos) {
            transacoes.addAll(importarArquivo(arquivo));
        }

        return transacoes;
    }

    private List<Transacao> importarArquivo(Path arquivo) {

        List<Transacao> transacoes = new ArrayList<>();

        try (Stream<String> linhas = Files.lines(arquivo)) {

            linhas
                    .skip(1) // pula cabeçalho
                    .filter(l -> !l.isBlank())
                    .forEach(linha -> {
                        String[] partes = linha.split(",");

                        LocalDate data = LocalDate.parse(partes[0]);
                        String descricao = partes[1];
                        BigDecimal valor = new BigDecimal(partes[2]);
                        TipoTransacao tipo = TipoTransacao.valueOf(partes[3]);
                        Categoria categoria = Categoria.valueOf(partes[4]);

                        transacoes.add(
                                new Transacao(
                                        data,
                                        descricao,
                                        descricao.toUpperCase(),
                                        valor,
                                        tipo,
                                        categoria
                                )
                        );
                    });

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler CSV: " + arquivo, e);
        }

        return transacoes;
    }
}
