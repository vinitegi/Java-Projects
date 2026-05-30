import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Objeto> listaObjeto = new ArrayList <>();

        for (int i = 0; i < 10; i++) {
            System.out.printf("Digite a descricao do objeto %s\n", i + 1);
            String descricao = scanner.nextLine();

            Objeto objeto = new Objeto(i, descricao);
            listaObjeto.add(objeto);
        }

        System.out.println("\n----------------------------------\n");

        for (int i = 0; i < 2; i++) {
            System.out.println("Informe o objeto que deseja alterar: ");
            int idBusca = scanner.nextInt();
            scanner.nextLine();

            if(idBusca > 0 && idBusca <= listaObjeto.size()) {
                Objeto objetoBuscado = listaObjeto.get(idBusca - 1);
                System.out.printf("Digite a nova descricao do objeto %s\n", idBusca);
                String novaDescricao = scanner.nextLine();
                objetoBuscado.setDescricao(novaDescricao);
            }
        }

        System.out.println("\n----------------------------------\n");

        for (int i = 0; i < 2; i++) {
            System.out.println("Informe o objeto que deseja exlcuir: ");
            int idBusca = scanner.nextInt();
            scanner.nextLine();

            if(idBusca > 0 && idBusca <= listaObjeto.size()) {
                listaObjeto.remove(idBusca - 1);
                System.out.println("Objeto removido com sucesso!");
            } else {
                System.out.println("ID invalido!");
            }
        }

        System.out.println("\n----------------------------------\n");

        for(int i = 0; i < listaObjeto.size(); i++) {
            System.out.println(listaObjeto.get(i));
        }

    }
}
