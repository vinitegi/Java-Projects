import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car carro = new Car();
        int opcao;

        do {
            System.out.println("\n===== MENU DO CARRO =====");
            System.out.println("1 - Ligar carro");
            System.out.println("2 - Desligar carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Trocar marcha");
            System.out.println("6 - Virar");
            System.out.println("7 - Verificar velocidade");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    carro.ligar();
                    break;
                case 2:
                    carro.desligar();
                    break;
                case 3:
                    carro.acelerar();
                    break;
                case 4:
                    carro.desacelerar();
                    break;
                case 5:
                    System.out.print("Digite a nova marcha (0 a 6): ");
                    int nova = sc.nextInt();
                    carro.trocarMarcha(nova);
                    break;
                case 6:
                    System.out.print("Digite a direção (esquerda/direita): ");
                    String dir = sc.next();
                    carro.virar(dir);
                    break;
                case 7:
                    carro.verificarVelocidade();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}