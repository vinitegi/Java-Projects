public class Atendente extends Funcionario {
    protected double valorEmCaixa;

    public Atendente(String nome, String email, String senha, double valorEmCaixa) {
        super(nome, email, senha, false);
        this.valorEmCaixa = valorEmCaixa;
    }

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void receberPagamento(double valor){
        this.valorEmCaixa += valor;
        System.out.println("Pagamento recebido: R$ " + valor);
    }

    public void fecharCaixa(){
        System.out.println("Caixa fechado. Total: R$ " + valorEmCaixa);
        this.valorEmCaixa = 0;
    }
}
