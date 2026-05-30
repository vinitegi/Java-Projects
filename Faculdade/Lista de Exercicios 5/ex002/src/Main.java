import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contato> lista = new ArrayList<>();

        int opcao = 0;
        int contadorId = 1;

        while (opcao != 6) {
            System.out.println("\n1 - Adicionar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por ID");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                case 1: // ADICIONAR
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Telefone: ");
                    String tel = sc.nextLine();

                    Contato novo = new Contato(contadorId++, nome, tel);
                    lista.add(novo);

                    System.out.println("Contato adicionado!");
                    break;

                case 2: // ALTERAR
                    System.out.print("Digite o ID: ");
                    int idAlt = sc.nextInt();
                    sc.nextLine();

                    for (Contato c : lista) {
                        if (c.getId() == idAlt) {
                            System.out.print("Novo nome: ");
                            c.setNome(sc.nextLine());

                            System.out.print("Novo telefone: ");
                            c.setTelefone(sc.nextLine());

                            System.out.println("Atualizado!");
                            break;
                        }
                    }
                    break;

                case 3: // EXCLUIR
                    System.out.print("Digite o ID: ");
                    int idExc = sc.nextInt();

                    lista.removeIf(c -> c.getId() == idExc);

                    System.out.println("Removido!");
                    break;

                case 4: // BUSCAR
                    System.out.print("Digite o ID: ");
                    int idBus = sc.nextInt();

                    for (Contato c : lista) {
                        if (c.getId() == idBus) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 5: // LISTAR
                    for (Contato c : lista) {
                        System.out.println(c);
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
