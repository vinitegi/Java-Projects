public class Cultura extends ProdutoBase {

    public Cultura(double preco) {
        super(preco);
    }

    @Override
    public double calcularImposto() {
        return preco * 0.04;
    }
}
