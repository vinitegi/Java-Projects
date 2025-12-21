public class Main {
    public static void main(String[] args) {
        Ingresso normal = new Ingresso(30, "How To Train Your Dragon", false);
        Ingresso meia = new MeiaEntrada(30, "How To Train Your Dragon", false);
        Ingresso familia = new IngressoFamilia(30, "How To Train Your Dragon", false, 5);

        System.out.println(normal.getValorReal());
        System.out.println(meia.getValorReal());
        System.out.println(familia.getValorReal());
    }
}
