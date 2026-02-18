public class Funcionario {
    protected String nome;
    protected String email;
    protected String senha;
    protected final boolean administrador;

    protected Funcionario(String nome, String email, String senha, boolean administrador) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.administrador = administrador;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void alterarSenha(String senha) {
        this.senha = senha;
    }

    public void alterarDados(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void efetuarLogin(){
        System.out.println(nome + " realizou login.");
    }

    public void efetuarLogoff(){
        System.out.println(nome + " realizou logoff.");
    }
}
