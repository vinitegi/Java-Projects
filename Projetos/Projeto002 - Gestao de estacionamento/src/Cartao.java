public class Cartao implements Pagamento{
    @Override
    public void pagar(double valor) {
        System.out.println("Pagando via cartao: R$" + valor);
    }
}
