public class Vestuario extends ProdutoBase{
    public Vestuario(double preco){
        super(preco);
    }

    @Override
    public double calcularImposto(){
        return preco * 0.025;
    }
}
