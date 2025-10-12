public class Account {
    private double saldo;
    private double chequeEspecial; //como se fosse o credito credito.
    private double usoChequeEspecial;

    //monta a conta pronta para uso, com saldo, limite e controle inicializado
    public Account(double depositoInicial){
        this.saldo = depositoInicial;

        if (depositoInicial <= 500){
            this.chequeEspecial = 50.0;
        } else {
            this.chequeEspecial = depositoInicial * 0.5;
        }
        this.usoChequeEspecial = 0;
    }

    //funcoes
     public void consultarSaldo(){
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
     }

     public void consultarChequeEspecial(){
         System.out.printf("Limite do cheque especial: R$ %.2f%n", chequeEspecial);
     }

     public void depositar(double valor){
        if (usoChequeEspecial > 0){
            double taxa = usoChequeEspecial * 0.2;
            double dividaTotal = usoChequeEspecial + taxa;

            System.out.printf("Voce estava usando o cheque especial. Será cobrada uma taxa de R$ %.2f\n", taxa);

            if (valor >= dividaTotal){
                valor -= dividaTotal;
                usoChequeEspecial = 0;
                saldo = valor;
                System.out.println("Cheque especial quitado e depósito realizado com sucesso!");
            } else {
                usoChequeEspecial -= (valor / 1.2); // reduz proporcionalmente o uso
                System.out.println("Parte do cheque especial foi quitada. Ainda resta saldo devedor.");
                saldo = 0;
            }
        } else {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        }
     }

     public void sacar(double valor){
        if (valor <= saldo){ //usa somente do saldo
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else if (valor <= saldo + chequeEspecial){ //vai precisar usar o cheque especial
            double falta = valor - saldo; //quanto sera retirado do cheque especial
            saldo -= valor; //vai ficar negativo
            chequeEspecial -= falta;
            usoChequeEspecial += falta;
            System.out.printf("Você usou R$ %.2f do cheque especial.%n", falta);
        } else {
            // Caso 3: nem com cheque especial é possível
            System.out.println("Saldo insuficiente, mesmo com o cheque especial.");
            return;
        }
         System.out.printf(
                 "Novo saldo: R$ %.2f%nQuantidade restante do cheque especial: R$ %.2f%n",
                 saldo, chequeEspecial
         );

     }

     public void pagarBoleto(double valor){
        System.out.println("Tentando pagar boleto de R$ " + valor);
        sacar(valor);
     }

    public void verificarUsoChequeEspecial() {
        if (usoChequeEspecial > 0) {
            System.out.printf("Você está usando R$ %.2f do cheque especial.%n", usoChequeEspecial);
        } else {
            System.out.println("Você não está usando o cheque especial.");
        }
    }
}
