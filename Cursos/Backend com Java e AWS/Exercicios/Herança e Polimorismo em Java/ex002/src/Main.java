import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Sistema sistema = new Sistema();

    public static void main(String[] args) {

        Gerente gerente = new Gerente("Carlos", "admin@email.com", "admin");

        Vendedor v1 = new Vendedor("João", "joao@email.com", "123", 30);
        Vendedor v2 = new Vendedor("Maria", "maria@email.com", "123", 20);

        Atendente a1 = new Atendente("Ana", "ana@email.com", "123", 10);

        sistema.adicionarVendedor(v1);
        sistema.adicionarVendedor(v2);
        sistema.adicionarAtendente(a1);


        int opcao;

        do {
            System.out.println("\n===== SISTEMA =====");
            System.out.println("1 - Login Gerente");
            System.out.println("2 - Login Vendedor");
            System.out.println("3 - Login Atendente");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> menuGerente(gerente);
                case 2 -> menuVendedor();
                case 3 -> menuAtendente();
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // ================= GERENTE =================
    private static void menuGerente(Gerente gerente) {
        gerente.efetuarLogin();
        int op;

        do {
            System.out.println("\n--- MENU GERENTE ---");
            System.out.println("1 - Consultar vendas");
            System.out.println("2 - Gerar relatório financeiro");
            System.out.println("0 - Logoff");
            System.out.print("Opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1 -> gerente.consultarVendas(sistema);
                case 2 -> {
                    System.out.print("Valor por venda: ");
                    double valor = sc.nextDouble();
                    gerente.gerarRelatorioFinanceiro(sistema, valor);
                }
                case 0 -> gerente.efetuarLogoff();
                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    // ================= VENDEDOR =================
    private static void menuVendedor() {
        System.out.println("\nEscolha o vendedor:");
        for (int i = 0; i < sistema.getVendedores().size(); i++) {
            System.out.println(i + " - " + sistema.getVendedores().get(i).getNome());
        }

        int index = sc.nextInt();
        Vendedor vendedor = sistema.getVendedores().get(index);

        vendedor.efetuarLogin();
        int op;

        do {
            System.out.println("\n--- MENU VENDEDOR ---");
            System.out.println("1 - Realizar venda");
            System.out.println("2 - Consultar minhas vendas");
            System.out.println("0 - Logoff");
            System.out.print("Opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1 -> vendedor.realizarVenda();
                case 2 -> vendedor.consultarVendas();
                case 0 -> vendedor.efetuarLogoff();
                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    // ================= ATENDENTE =================
    private static void menuAtendente() {
        System.out.println("\nEscolha o atendente:");
        for (int i = 0; i < sistema.getAtendentes().size(); i++) {
            System.out.println(i + " - " + sistema.getAtendentes().get(i).getNome());
        }

        int index = sc.nextInt();
        Atendente atendente = sistema.getAtendentes().get(index);

        atendente.efetuarLogin();
        int op;

        do {
            System.out.println("\n--- MENU ATENDENTE ---");
            System.out.println("1 - Receber pagamento");
            System.out.println("2 - Fechar caixa");
            System.out.println("0 - Logoff");
            System.out.print("Opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.print("Valor recebido: ");
                    double valor = sc.nextDouble();
                    atendente.receberPagamento(valor);
                }
                case 2 -> atendente.fecharCaixa();
                case 0 -> atendente.efetuarLogoff();
                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }
}
