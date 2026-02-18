public class IngressoFamilia extends Ingresso {

    private final int numeroPessoas;

    public IngressoFamilia(double valor, String nomeFilme, boolean dublado, int numeroPessoas) {
        super(valor, nomeFilme, dublado);
        this.numeroPessoas = numeroPessoas;
    }

    @Override
    public double getValorReal(){
        double valorTotal = valor * numeroPessoas;

        if (numeroPessoas > 3){
            valorTotal *= 0.95;
        }

        return valorTotal;
    }
}
