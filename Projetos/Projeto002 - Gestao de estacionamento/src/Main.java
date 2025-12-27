import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final EstacionamentoService estacionamento = new EstacionamentoService();

    public static void main(String[] args) {
        int opcao;

        do{
            mostrarMenu();
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> entradaVeiculo();
                case 2 -> saidaVeiculo();
                case 3 -> listarVeiculos();
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opcao invalida!");
            }
        }while(opcao != 0);
    }

    private static void mostrarMenu(){
        System.out.println("\n=== ESTACIONAMENTO ===");
        System.out.println("1 - Entrada de veiculo");
        System.out.println("2 - Saida de veiculo");
        System.out.println("3 - Listar veiculos");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }
    private static void entradaVeiculo(){
        System.out.println("Digite a placa do veiculo: ");
        String placa = sc.nextLine();

        System.out.println("Digite o tipo do veiculo: \n" +
                "1 - Carro | 2 - Moto");
        int tipo = sc.nextInt();

        Veiculo automovel;
        if(tipo == 1){
            automovel = new Carro(placa);
        } else if(tipo == 2){
            automovel = new Moto(placa);
        } else {
            System.out.println("Opcao invalida!");
            return;
        }

        estacionamento.entradaVeiculo(automovel);
    }
    private static void saidaVeiculo(){
        if (estacionamento.listarVeiculos().isEmpty()) {
            System.out.println("Nenhum veiculo no estacionamento!");
            return;
        }
        try {
            System.out.print("Placa: ");
            String placa = sc.nextLine();

            double valor = estacionamento.saidaVeiculo(placa);

            Pagamento divida = escolherPagamento();
            divida.pagar(valor);

        } catch (VeiculoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

    }
    private static void listarVeiculos(){
        if (estacionamento.listarVeiculos().isEmpty()) {
            System.out.println("Nenhum veiculo no estacionamento!");
            return;
        }

        System.out.println("Veiculos no estacionamento:");
        estacionamento.listarVeiculos().forEach(v ->
                System.out.println("Placa: " + v.getPlaca())
        );
    }
    private static Pagamento escolherPagamento(){
        System.out.print("Pagamento (1-Pix | 2-Cartao): ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            return new Pix();
        } else if (op == 2) {
            return new Cartao();
        } else {
            System.out.println("Forma invalida, usando Pix.");
            return new Pix();
        }
    }
}
