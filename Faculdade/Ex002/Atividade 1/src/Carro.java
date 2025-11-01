import java.util.Objects;

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private Double valor;
    private int ano;

    public Carro(){
    }

    public Carro(String marca, String modelo, String cor, Double valor, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return ano == carro.ano && Objects.equals(marca, carro.marca) && Objects.equals(modelo, carro.modelo) && Objects.equals(cor, carro.cor) && Objects.equals(valor, carro.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, cor, valor, ano);
    }

    @Override
    public String toString() {
        return "Carro {" +
                "Marca='" + marca + '\'' +
                ", Modelo='" + modelo + '\'' +
                ", Ano=" + ano +
                ", Cor='" + cor + '\'' +
                ", Preço=R$" + valor +
                '}';
    }
}
