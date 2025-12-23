public class Alimentacao extends ProdutoBase{

    public Alimentacao(double preco) {
       super(preco);
   }

    @Override
    public double calcularImposto() {
        return preco * 0.01;
    }
}
