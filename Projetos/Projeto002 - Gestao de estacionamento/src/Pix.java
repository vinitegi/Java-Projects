public class Pix implements Pagamento{
    @Override
    public void pagar(double valor) {
        System.out.println("Pagando pix: R$" + valor);
    }
}
