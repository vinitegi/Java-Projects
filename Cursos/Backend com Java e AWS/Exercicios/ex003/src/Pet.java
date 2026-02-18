public class Pet {

    private final String nome;
    private boolean statusLimpeza;

    public Pet(String nome) {
        this.nome = nome;
        this.statusLimpeza = false; //sempre vai estar sujo
    }

    public String getNome() {
        return nome;
    }

    public boolean getStatusLimpeza() {
        return statusLimpeza;
    }

    public void setStatusLimpeza(boolean limpo) {
        this.statusLimpeza = limpo;
    }


}
