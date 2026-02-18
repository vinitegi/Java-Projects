import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor do deposto inicial: R$ ");
        double depositoInicial = sc.nextDouble();
        account conta1 = new account(depositoInicial);

        int opcao;
        do {
            System.out.println("\n====== MENU BANCÁRIO ======");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar cheque especial");
            System.out.println("3. Depositar dinheiro");
            System.out.println("4. Sacar dinheiro");
            System.out.println("5. Pagar boleto");
            System.out.println("6. Verificar uso do cheque especial");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    conta1.consultarSaldo();
                    break;
                case 2:
                    conta1.consultarChequeEspecial();
                    break;
                case 3:
                    System.out.print("Valor do depósito: R$ ");
                    double dep = sc.nextDouble();
                    conta1.depositar(dep);
                    break;
                case 4:
                    System.out.print("Valor do saque: R$ ");
                    double saq = sc.nextDouble();
                    conta1.sacar(saq);
                    break;
                case 5:
                    System.out.print("Valor do boleto: R$ ");
                    double bol = sc.nextDouble();
                    conta1.pagarBoleto(bol);
                    break;
                case 6:
                    conta1.verificarUsoChequeEspecial();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema... até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}