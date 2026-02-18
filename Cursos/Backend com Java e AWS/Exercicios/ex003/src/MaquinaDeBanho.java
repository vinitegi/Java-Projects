public class MaquinaDeBanho {
    //constantes
    private final int MAX_AGUA = 30;
    private final int MAX_SHAMPOO = 10;

    //banho
    private final int CONSUMO_AGUA_BANHO = 10;
    private final int CONSUMO_SHAMPOO_BANHO = 2;

    //limpeza maquina
    private final int CONSUMO_AGUA_LIMPEZA = 3;
    private final int CONSUMO_SHAMPOO_LIMPEZA = 1;

    //abastecimento
    private final int QTD_ABASTECIMENTO = 2;

    //estado da maquina
    private int nivelAgua;
    private int nivelShampoo;
    private boolean limpa = true;

    private Pet pet;

    public void abastecerAgua() {
        if (nivelAgua >= MAX_AGUA) {
            System.out.println("Tanque de água já está cheio!");
            return;
        }
        nivelAgua += QTD_ABASTECIMENTO;
        if (nivelAgua > MAX_AGUA) nivelAgua = MAX_AGUA;
        System.out.println("Água abastecida (+2L). Nível atual: " + nivelAgua + "L");
    }
    public void abastecerShampoo() {
        if (nivelShampoo >= MAX_SHAMPOO) {
            System.out.println("Tanque de shampoo já está cheio!");
            return;
        }
        nivelShampoo += QTD_ABASTECIMENTO;
        if (nivelShampoo > MAX_SHAMPOO) nivelShampoo = MAX_SHAMPOO;
        System.out.println("Shampoo abastecido (+2L). Nível atual: " + nivelShampoo + "L");
    }
    public void verificarNiveis() {
        System.out.println("--- NÍVEIS ATUAIS ---");
        System.out.println("Água: " + nivelAgua + "/" + MAX_AGUA + "L");
        System.out.println("Shampoo: " + nivelShampoo + "/" + MAX_SHAMPOO + "L");
        System.out.println("Status Máquina: " + (limpa ? "LIMPA" : "SUJA (Precisa limpar)"));
        System.out.println("---------------------");
    }

    public boolean temPet() {
        return pet != null;
    }
    public void verificarPet() {
        if (temPet()) {
            System.out.println("Pet na máquina: " + pet.getNome() +
                    (pet.getStatusLimpeza() ? " (limpo)" : " (sujo)"));
        } else {
            System.out.println("Não há pet na máquina.");
        }
    }


    public void colocarPet(Pet pet) {
        if(!this.limpa){ //maquina
            System.out.println("A maquina esta suja. Limpe-a para continuar!");
            return;
        }
        if (temPet()) {
            System.out.println("O pet " + this.pet.getNome() + "esta na maquina");
            return;
        }
        this.pet = pet;
    }
    public void darBanho() {
        if (pet == null) {
            System.out.println("Coloque o pet na máquina para iniciar o banho.");
            return;
        }

        if (nivelAgua < CONSUMO_AGUA_BANHO || nivelShampoo < CONSUMO_SHAMPOO_BANHO) {
            System.out.println("Quantidade de produtos insuficiente para o banho.");
            return;
        }

        nivelAgua -= CONSUMO_AGUA_BANHO;
        nivelShampoo -= CONSUMO_SHAMPOO_BANHO;
        pet.setStatusLimpeza(true);

        System.out.println("O pet " + pet.getNome() + " está limpo.");
    }
    public void tirarPet() {
        if (pet == null) {
            System.out.println("Não há pet na máquina.");
            return;
        }
        // se o pet saiu sujo, a máquina fica suja
        this.limpa = pet.getStatusLimpeza();

        System.out.println("O pet " + pet.getNome() +
                (pet.getStatusLimpeza() ? " saiu limpo." : " saiu sujo."));

        this.pet = null; // agora sim remove
    }
    public void limparMaquina(){
        if(this.limpa){
            System.out.println("A maquina ja esta limpa");
            return;
        }

        if (nivelAgua < CONSUMO_AGUA_LIMPEZA || nivelShampoo < CONSUMO_SHAMPOO_LIMPEZA) {
            System.out.println("Quantidade de produtos insuficiente para a limpeza.");
            return;
        }
        nivelAgua -= CONSUMO_AGUA_LIMPEZA;
        nivelShampoo -= CONSUMO_SHAMPOO_LIMPEZA;
        this.limpa = true;
    }
}
