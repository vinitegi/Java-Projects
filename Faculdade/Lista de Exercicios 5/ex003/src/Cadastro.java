import java.util.List;

public interface Cadastro<T> {
    public void Inserir(T obj);
    public void Alterar(int indice, T obj);
    public void Excluir(int indice);
    List<T> Listar();

}
