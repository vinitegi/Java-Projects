import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cadastro<Produto> cadastro = new Cadastro<Produto>() {

            private List<Produto> lista = new ArrayList<>();

            @Override
            public void Inserir(Produto obj) {
                lista.add(obj);
            }

            @Override
            public void Alterar(int indice, Produto obj) {
                if (indice >= 0 && indice < lista.size()) {
                    lista.set(indice, obj);
                }
            }

            @Override
            public void Excluir(int indice) {
                if (indice >= 0 && indice < lista.size()) {
                    lista.remove(indice);
                }
            }

            @Override
            public List<Produto> Listar() {
                return lista;
            }
        };

        Produto p = new Produto("Notebook");

        Controladora.gerenciar(cadastro, p);
    }
}
