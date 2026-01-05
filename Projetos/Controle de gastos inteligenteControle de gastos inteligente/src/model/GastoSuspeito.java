package model;

import java.math.BigDecimal;

public class GastoSuspeito {
    private final String descricao;
    private final BigDecimal impactoMensal;
    private final String motivo;

    public GastoSuspeito(String descricao, BigDecimal impactoMensal, String motivo) {
        this.descricao = descricao;
        this.impactoMensal = impactoMensal;
        this.motivo = motivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getImpactoMensal() {
        return impactoMensal;
    }

    public String getMotivo() {
        return motivo;
    }
}
