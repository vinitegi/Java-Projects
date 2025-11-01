public class ContaCorrente extends Account{
    protected double taxaManutencao;

    public ContaCorrente(String titular, int id, double saldo, double taxaManutencao){
        super(titular, id, saldo); //chama o construtor da classe pai
        this.taxaManutencao = taxaManutencao;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public void atualizarSaldo(){
        saldo -= taxaManutencao;
        System.out.printf("Taxa mensal de R$ %s descontada", taxaManutencao);
    }
}
