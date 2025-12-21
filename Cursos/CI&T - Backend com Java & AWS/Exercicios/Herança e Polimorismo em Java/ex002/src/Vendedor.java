public class Vendedor extends Funcionario{

    protected int quantidadeVendas;

    public Vendedor(String nome, String email, String senha, int quantidadeVendas) {
        super(nome, email, senha, false);
        this.quantidadeVendas = quantidadeVendas;
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void realizarVenda() {
        quantidadeVendas++;
    }

    public void consultarVendas() {
        System.out.println("Minhas vendas: " + quantidadeVendas);
    }
}
