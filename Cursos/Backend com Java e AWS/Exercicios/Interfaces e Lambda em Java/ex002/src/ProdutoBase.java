public abstract class ProdutoBase implements Produto {

    protected double preco;

    public ProdutoBase(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        this.preco = preco;
    }
}