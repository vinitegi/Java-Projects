public class Main {
    public static void main(String[] args) {
        Marketing marketing = new Marketing();
        String mensagem = "Promoção imperdível! 50% OFF hoje!";

        marketing.enviar(new SMS(), mensagem);
        marketing.enviar(new Email(), mensagem);
        marketing.enviar(new RedesSociais(), mensagem);
        marketing.enviar(new Wpp(), mensagem);

    }
}
