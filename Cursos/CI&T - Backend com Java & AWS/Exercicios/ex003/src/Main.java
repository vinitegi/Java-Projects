import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MaquinaDeBanho maquina = new MaquinaDeBanho();
        int opcao = -1;

        do {
            System.out.println("\n=== CONTROLE DE PETSHOP (JAVA) ===");
            System.out.println("1. Abastecer Água");
            System.out.println("2. Abastecer Shampoo");
            System.out.println("3. Verificar Níveis");
            System.out.println("4. Colocar Pet");
            System.out.println("5. Dar Banho");
            System.out.println("6. Retirar Pet");
            System.out.println("7. Limpar Máquina");
            System.out.println("8. Verificar se tem Pet");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    maquina.abastecerAgua();
                    break;
                case 2:
                    maquina.abastecerShampoo();
                    break;
                case 3:
                    maquina.verificarNiveis();
                    break;
                case 4:
                    System.out.println("Digite o nome do pet:");
                    String nome = scanner.nextLine();
                    Pet pet = new Pet(nome);
                    maquina.colocarPet(pet);
                    break;
                case 5:
                    maquina.darBanho();
                    break;
                case 6:
                    maquina.tirarPet();
                    break;
                case 7:
                    maquina.limparMaquina();
                    break;
                case 8:
                    maquina.temPet();
                    maquina.verificarPet();
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        while (opcao != 0) ;
    }
}