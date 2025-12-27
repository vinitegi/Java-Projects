public class Moto extends Veiculo{

    public Moto(String placa){
        super(placa);
    }

    @Override
    public double calcularValor(){
        return getTempoEmMinuto() * 0.05;
    }
}
