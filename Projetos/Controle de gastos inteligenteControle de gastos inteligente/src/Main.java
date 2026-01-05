import enums.Categoria;
import enums.TipoTransacao;
import model.GastoRecorrente;
import model.Transacao;
import service.DetectorRecorrenciaService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Transacao> transacoes = List.of(

                new Transacao(
                        LocalDate.of(2024, 1, 10),
                        "Spotify",
                        "SPOTIFY",
                        new BigDecimal("34.90"),
                        TipoTransacao.SAIDA,
                        Categoria.ASSINATURA
                ),

                new Transacao(
                        LocalDate.of(2024, 2, 10),
                        "Spotify",
                        "SPOTIFY",
                        new BigDecimal("34.90"),
                        TipoTransacao.SAIDA,
                        Categoria.ASSINATURA
                ),

                new Transacao(
                        LocalDate.of(2024, 3, 10),
                        "Spotify",
                        "SPOTIFY",
                        new BigDecimal("34.90"),
                        TipoTransacao.SAIDA,
                        Categoria.ASSINATURA
                ),

                new Transacao(
                        LocalDate.of(2024, 1, 5),
                        "Mercado",
                        "MERCADO",
                        new BigDecimal("120.00"),
                        TipoTransacao.SAIDA,
                        Categoria.ALIMENTACAO
                )
        );

        DetectorRecorrenciaService detector = new DetectorRecorrenciaService();

        List<GastoRecorrente> recorrentes = detector.detectar(transacoes);

        recorrentes.forEach(System.out::println);
    }
}
