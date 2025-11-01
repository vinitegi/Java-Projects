import java.util.ArrayList;

public class Banco {
    protected ArrayList<Account> contas; //cria uma lista do tipo Account chamada contas

    public Banco(){
        contas = new ArrayList<>(); //construtor ja cria a lista por padrao
    }

    public void adicionarConta(Account conta){  //adicona uma nova conta na lista
        contas.add(conta);
        System.out.printf("Conta de %s adicionada ao banco\n", conta.getTitular());
    }

    public void removerConta(Account conta){ //remove uma nova conta da lista
        contas.remove(conta);
        System.out.printf("Conta de %s removida do banco\n", conta.getTitular());
    }

    public Account buscarConta(int id){ //busca a conta desejada
        for (Account c : contas){
            if (c.getId() == id){
                return c;
            }
        }
        System.out.println("Conta não encontrada.");
        return null;
    }

    public void listarConta(){ //lista todas as contas existentes
        System.out.println("=== Todas as Contas do Banco ===");
        for (Account c : contas){
            c.exibirInfo();
            System.out.println();
        }
    }

    public double totalEmCaixa(){ //ve quanto de dinheiro tem em todas as contas
        double total = 0;
        for (Account c : contas){
            total += c.getSaldo();
        }
        return total;
    }
}
