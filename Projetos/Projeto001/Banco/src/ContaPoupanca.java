public class ContaPoupanca extends Account {
    protected double taxaRendimento;

    public ContaPoupanca(String titular, int id, double saldo, double taxaRendimento){
        super(titular, id, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void atualizarSaldo(){
        double rendimento = saldo * (taxaRendimento / 100);
        saldo += rendimento;
        System.out.printf("Rendimento de R$ %s aplicado a conta poupança", rendimento);
    }
}
