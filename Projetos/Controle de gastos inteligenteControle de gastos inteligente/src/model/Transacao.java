package model;

import enums.Categoria;
import enums.TipoTransacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transacao {
    private LocalDate data;
    private final String descricaoOriginal;
    private final String descricaoNormalizada;
    private final BigDecimal valor;
    private final TipoTransacao tipo;
    private final Categoria categoria;

    public Transacao(LocalDate data,
                     String descricaoOriginal, String descricaoNormalizada,
                     BigDecimal valor,
                     TipoTransacao tipo, Categoria categoria) {
        this.data = data;
        this.descricaoOriginal = descricaoOriginal;
        this.descricaoNormalizada = descricaoNormalizada;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescricaoOriginal() {
        return descricaoOriginal;
    }

    public String getDescricaoNormalizada() {
        return descricaoNormalizada;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transacao)) return false;
        Transacao that = (Transacao) o;

        return Objects.equals(data, that.data)
                && Objects.equals(descricaoNormalizada, that.descricaoNormalizada)
                && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, descricaoNormalizada, valor);
    }
}
