package service;

import enums.TipoTransacao;
import model.GastoRecorrente;
import model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DetectorRecorrenciaService {

    private static final int MIN_MESES_RECORRENCIA = 3;

    public List<GastoRecorrente> detectar(List<Transacao> transacoes) {

        return transacoes.stream()
                // 1️⃣ Apenas SAÍDAS
                .filter(t -> t.getTipo() == TipoTransacao.SAIDA)
                .collect(Collectors.groupingBy(Transacao::getDescricaoNormalizada))
                .values()
                .stream()
                .filter(this::ehRecorrente)
                .map(this::criarGastoRecorrente)
                .toList();
    }

    private boolean ehRecorrente(List<Transacao> transacoes) {
        return transacoes.stream()
                .map(t -> t.getData().getMonth())
                .distinct()
                .count() >= MIN_MESES_RECORRENCIA;
    }

    private GastoRecorrente criarGastoRecorrente(List<Transacao> transacoes) {

        transacoes.sort(Comparator.comparing(Transacao::getData));

        LocalDate primeira = transacoes.get(0).getData();
        LocalDate ultima = transacoes.get(transacoes.size() - 1).getData();

        long meses = ChronoUnit.MONTHS.between(
                primeira.withDayOfMonth(1),
                ultima.withDayOfMonth(1)
        ) + 1;

        BigDecimal soma = transacoes.stream()
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal valorMedio = soma.divide(
                BigDecimal.valueOf(transacoes.size()),
                2,
                BigDecimal.ROUND_HALF_UP
        );

        int frequenciaMensal = (int) Math.max(1, transacoes.size() / meses);

        return new GastoRecorrente(
                transacoes.get(0).getDescricaoNormalizada(),
                valorMedio,
                primeira,
                ultima,
                frequenciaMensal,
                transacoes
        );
    }
}