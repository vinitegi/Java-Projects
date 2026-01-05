package model;

import enums.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class GastoRecorrente {

    private final String descricaoNormalizada;
    private final BigDecimal valorMedio;
    private final LocalDate primeiraOcorrencia;
    private final LocalDate ultimaOcorrencia;
    private final int frequenciaMensal;
    private final Categoria categoria;
    private final List<Transacao> transacoes;

    public GastoRecorrente(String descricaoNormalizada,
                           BigDecimal valorMedio,
                           LocalDate primeiraOcorrencia,
                           LocalDate ultimaOcorrencia,
                           int frequenciaMensal,
                           List<Transacao> transacoes) {

        this.descricaoNormalizada = descricaoNormalizada;
        this.valorMedio = valorMedio;
        this.primeiraOcorrencia = primeiraOcorrencia;
        this.ultimaOcorrencia = ultimaOcorrencia;
        this.frequenciaMensal = frequenciaMensal;
        this.transacoes = List.copyOf(transacoes);
        this.categoria = transacoes.get(0).getCategoria();
    }

    @Override
    public String toString() {
        return "GastoRecorrente {" +
                "descricao='" + descricaoNormalizada + '\'' +
                ", categoria=" + categoria +
                ", valorMedio=" + valorMedio +
                ", frequenciaMensal=" + frequenciaMensal +
                ", periodo=" + primeiraOcorrencia + " → " + ultimaOcorrencia +
                '}';
    }
}
