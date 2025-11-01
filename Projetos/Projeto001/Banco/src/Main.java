import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco bank = new Banco();
        Scanner sc = new Scanner(System.in);

        //add contas
        bank.adicionarConta(new ContaCorrente("Vinicus Tegi", 113, 1000.00, 20.0));
        bank.adicionarConta(new ContaPoupanca("Filippi Leite", 109, 500.00, 1.5));

        int op;
        do {
            System.out.println("\n=== Menu Banco ===");
            System.out.println("1 - Listar contas");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Atualizar saldo");
            System.out.println("6 - Adicionar conta");
            System.out.println("7 - Remover conta");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op){
                case 1 -> bank.listarConta();
                case 2 -> {
                    System.out.print("ID da conta: ");
                    int id = sc.nextInt();
                    System.out.print("Valor do deposito: ");
                    double valor = sc.nextDouble();
                    Account conta = bank.buscarConta(id);
                    if (conta != null){
                        conta.depositar(valor);
                    }
                }
                case 3 -> {
                    System.out.print("ID da conta: ");
                    int id = sc.nextInt();
                    System.out.print("Valor do saque: ");
                    double valor = sc.nextDouble();
                    Account conta = bank.buscarConta(id);
                    if (conta != null){
                        conta.sacar(valor);
                    }
                }
                case 4 -> {
                    System.out.println("ID da conta de origem");
                    int idOrigem = sc.nextInt();
                    System.out.println("ID da conta destino");
                    int idDestino = sc.nextInt();
                    System.out.print("Valor da transferencia: ");
                    double valor = sc.nextDouble();

                    Account origem = bank.buscarConta(idOrigem);
                    Account destino = bank.buscarConta(idDestino);
                    if (origem != null && destino != null){
                        origem.transferir(valor, destino);
                    }
                }
                case 5 -> {
                    System.out.print("ID da conta: ");
                    int id = sc.nextInt();
                    Account conta = bank.buscarConta(id);
                    if (conta != null){
                        conta.atualizarSaldo();
                    }
                }
                case 6 -> {
                    System.out.print("Digite o tipo de conta (1-Corrente, 2-Poupança): ");
                    int tipo = sc.nextInt();
                    sc.nextLine(); // limpar buffer
                    System.out.print("Titular: ");
                    String titular = sc.nextLine();
                    System.out.print("ID da conta: ");
                    int id = sc.nextInt();
                    System.out.print("Saldo inicial: ");
                    double saldo = sc.nextDouble();

                    Account novaConta;
                    if (tipo == 1){
                        System.out.println("Digite a taxa de manutenção");
                        double taxa = sc.nextDouble();
                        novaConta = new ContaCorrente(titular, id, saldo, taxa);
                    } else {
                        System.out.print("Digite a taxa de rendimento (%): ");
                        double taxa = sc.nextDouble();
                        novaConta = new ContaPoupanca(titular, id, saldo, taxa);
                    }

                    bank.adicionarConta(novaConta);
                }
                case 7 -> {
                    System.out.print("ID da conta que sera excluida: ");
                    int id = sc.nextInt();
                    Account conta = bank.buscarConta(id);
                    if (conta != null){
                        bank.removerConta(conta);
                    }
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }
}
