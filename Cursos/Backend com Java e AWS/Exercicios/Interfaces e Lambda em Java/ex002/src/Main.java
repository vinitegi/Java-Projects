public class Main {
    public static void main(String[] args) {

        Produto p1 = new Alimentacao(100.0);
        Produto p2 = new Saude(200.0);
        Produto p3 = new Cultura(300.0);
        Produto p4 = new Vestuario(400.0);

        System.out.println("Imposto Alimentação: R$" + p1.calcularImposto());
        System.out.println("Imposto Saude: R$" + p2.calcularImposto());
        System.out.println("Imposto Cultura: R$" + p3.calcularImposto());
        System.out.println("Imposto Vestuario: R$" + p4.calcularImposto());
    }
}
