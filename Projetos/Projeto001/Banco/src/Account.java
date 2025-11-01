public class Account { //classe pai
    protected String titular;
    protected int id;
    protected Double saldo;

    //construtor
    public Account(String titular, int id, Double saldo){
        this.titular = titular;
        this.id = id;
        this.saldo = saldo;
    }

    //getter e setter
    public String getTitular() {
        return titular;
    }

    public int getId(){
        return id;
    }

    public Double getSaldo(){
        return saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }

    //metodos
    public void depositar(double valor){
        saldo += valor;
    }

    public void sacar(double valor){
        if (valor > saldo){
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= saldo;
            System.out.println("Saque realziado com sucesso");
        }
    }

    public void transferir(double valor, Account contaDestino){
        if (valor > 0 && this.saldo >= valor){
            this.saldo -= valor;
            contaDestino.depositar(valor);
            System.out.printf("Transferência de R$ %s realizada com sucesso para %s", valor, contaDestino);
        } else {
            System.out.println("Transferência não realizada. Saldo insuficiente ou valor inválido.");
        }
    }

    public void exibirInfo(){
        System.out.println("=== Dados da Conta ===");
        System.out.println("Titular: " + this.titular);
        System.out.println("Número: " + this.id);
        System.out.println("Saldo: R$" + String.format("%.2f", this.saldo));
    }

    public void atualizarSaldo() {
    }
}
