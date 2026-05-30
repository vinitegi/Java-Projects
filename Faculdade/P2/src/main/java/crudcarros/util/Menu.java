package crudcarros.util;

import crudcarros.model.Carro;
import crudcarros.service.CarroService;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private final CarroService carroService;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.carroService = new CarroService();
    }

    public void iniciar() {
        System.out.println("============================================");
        System.out.println("|        SISTEMA DE CADASTRO DE CARROS     |");
        System.out.println("============================================\n");

        int opcao = -1;
        do {
            exibirMenu();
            opcao = lerInteiro("Digite a opção: ");
            processarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("Sistema encerrado...");
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("=========================================");
        System.out.println("  1. Cadastrar novo carro");
        System.out.println("  2. Listar todos os carros");
        System.out.println("  3. Buscar carro por ID");
        System.out.println("  4. Atualizar carro");
        System.out.println("  5. Excluir carro");
        System.out.println("  0. Sair");
        System.out.println("=========================================");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> menuCadastrar();
            case 2 -> menuListarTodos();
            case 3 -> menuBuscarPorId();
            case 4 -> menuAtualizar();
            case 5 -> menuDeletar();
            case 0 -> {}
            default -> System.out.println("Opcao invalida!\n");
        }
    }

    private void menuCadastrar() {
        System.out.println("\n== CADASTRAR CARRO ==");
        try {
            String modelo = lerString("Modelo: ");
            String marca  = lerString("Marca: ");
            int    ano    = lerInteiro("Ano: ");
            String cor    = lerString("Cor: ");
            double preco  = lerDouble("Preço R$: ");

            Carro c = carroService.cadastrarCarro(modelo, marca, ano, cor, preco);
            System.out.println("\nCarro cadastrado com sucesso!");
            System.out.println(c);
        } catch (Exception e) {
            System.out.println("\nX " + e.getMessage());
        }
        System.out.println();
    }

    private void menuListarTodos() {
        System.out.println("\n== LISTA DE CARROS ==");
        try {
            List<Carro> carros = carroService.listarCarros();
            if (carros.isEmpty()) {
                System.out.println("Nenhum carro cadastrado.");
            } else {
                System.out.println("Total: " + carros.size() + " carro(s)\n");
                carros.forEach(c -> System.out.println(c + "\n"));
            }
        } catch (Exception e) {
            System.out.println("\nX " + e.getMessage());
        }
        System.out.println();
    }

    private void menuBuscarPorId() {
        System.out.println("\n== BUSCAR CARRO ==");
        try {
            int id = lerInteiro("ID: ");
            System.out.println(carroService.buscarCarroPorId(id));
        } catch (Exception e) {
            System.out.println("\nX " + e.getMessage());
        }
        System.out.println();
    }


    private void menuAtualizar() {
        System.out.println("\n== ATUALIZAR CARRO ==");
        try {
            int id = lerInteiro("ID do carro: ");

            System.out.println("\nDados atuais:");
            System.out.println(carroService.buscarCarroPorId(id));
            System.out.println("\nNovos dados:");

            String modelo = lerString("Modelo: ");
            String marca  = lerString("Marca: ");
            int    ano    = lerInteiro("Ano: ");
            String cor    = lerString("Cor: ");
            double preco  = lerDouble("Preço R$: ");

            Carro c = carroService.atualizarCarro(id, modelo, marca, ano, cor, preco);
            System.out.println("\nAtualizado com sucesso!");
            System.out.println(c);
        } catch (Exception e) {
            System.out.println("\nX" + e.getMessage());
        }
        System.out.println();
    }

    private void menuDeletar() {
        System.out.println("\n== EXCLUIR CARRO ==");
        try {
            int id = lerInteiro("ID do carro: ");

            System.out.println(carroService.buscarCarroPorId(id));
            System.out.print("\nConfirmar exclusao? (s/n): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("s")) {
                carroService.deletarCarro(id);
                System.out.println("Carro excluido com sucesso!");
            } else {
                System.out.println("Operacao cancelada.");
            }
        } catch (Exception e) {
            System.out.println("\nX " + e.getMessage());
        }
        System.out.println();
    }

    private String lerString(String prompt) {
        String v;
        do {
            System.out.print(prompt);
            v = scanner.nextLine().trim();
            if (v.isEmpty()) System.out.println("Campo obrigatorio.");
        } while (v.isEmpty());
        return v;
    }

    private int lerInteiro(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Digite um numero inteiro."); }
        }
    }

    private double lerDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Double.parseDouble(scanner.nextLine().trim().replace(",", ".")); }
            catch (NumberFormatException e) { System.out.println("Digite um valor numerico (ex: 45000.00)."); }
        }
    }
}
