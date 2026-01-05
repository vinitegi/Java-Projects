package model;

import java.math.BigDecimal;
import java.util.List;

public class RelatorioFinanceiro {
    private final BigDecimal gastoTotalMensal;
    private final BigDecimal gastoTotalAnual;
    private final List<GastoRecorrente> gastoRecorrentes;
    private final List<GastoSuspeito> gastoSuspeitos;

    public RelatorioFinanceiro(BigDecimal gastoTotalMensal,
                               BigDecimal gastoTotalAnual,
                               List<GastoRecorrente> gastoRecorrentes,
                               List<GastoSuspeito> gastoSuspeitos) {
        this.gastoTotalMensal = gastoTotalMensal;
        this.gastoTotalAnual = gastoTotalAnual;
        this.gastoRecorrentes = gastoRecorrentes;
        this.gastoSuspeitos = gastoSuspeitos;
    }

    public BigDecimal getGastoTotalMensal() {
        return gastoTotalMensal;
    }

    public BigDecimal getGastoTotalAnual() {
        return gastoTotalAnual;
    }

    public List<GastoRecorrente> getGastoRecorrentes() {
        return gastoRecorrentes;
    }

    public List<GastoSuspeito> getGastoSuspeitos() {
        return gastoSuspeitos;
    }
}
