public class Carro extends Veiculo{

    public Carro(String placa){
        super(placa);
    }

    @Override
    public double calcularValor() {
        return getTempoEmMinuto() * 0.10;
    }
}
