package crudcarros.model;

public class Carro {
    private int id;
    private String modelo;
    private String marca;
    private int ano;
    private String cor;
    private double preco;

    public Carro() {}

    //puxa dados do BD
    public Carro(int id, String modelo, String marca, int ano, String cor, double preco) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
    }

    //inserir carro - sem id -> autoincrement no BD
    public Carro(String modelo, String marca, int ano, String cor, double preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
    }


    public int getId() {
        return id;
    }
    public String getModelo(){
        return modelo;
    }
    public String getMarca(){
        return marca;
    }
    public int getAno(){
        return ano;
    }
    public String getCor(){
        return cor;
    }
    public double getPreco(){
        return preco;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setModelo(String m){
        this.modelo = m;
    }
    public void setMarca(String m){
        this.marca = m;
    }
    public void setAno(int ano){
        this.ano = ano;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public void setPreco(double p){
        this.preco = p;
    }

    @Override
    public String toString() {
        return String.format(
                "========================================%n" +
                        "│  ID     : %-27d│%n" +
                        "│  Modelo : %-27s│%n" +
                        "│  Marca  : %-27s│%n" +
                        "│  Ano    : %-27d│%n" +
                        "│  Cor    : %-27s│%n" +
                        "│  Preço  : R$ %-24.2f│%n" +
                "=========================================",
                id, modelo, marca, ano, cor, preco
        );
    }
}
