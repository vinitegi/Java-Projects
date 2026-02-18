public class Saude extends ProdutoBase{

    public Saude(double preco){
        super(preco);
    }

    @Override
    public double calcularImposto(){
        return preco * 0.015;
    }
}
