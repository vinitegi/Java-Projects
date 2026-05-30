public class Controladora {
    public static <T> void gerenciar(Cadastro<T> cadastro, T obj) {
        cadastro.Inserir(obj);

        System.out.println("Após inserir:");
        System.out.println(cadastro.Listar());

        cadastro.Alterar(0, obj);

        System.out.println("Após alterar:");
        System.out.println(cadastro.Listar());

        cadastro.Excluir(0);

        System.out.println("Após excluir:");
        System.out.println(cadastro.Listar());
    }
}