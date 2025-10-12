public class Car {
    private boolean ligado;
    private int velocidade;
    private int marcha;

    //objeto principal
    public Car(){
        ligado = false;
        marcha = 0;
        velocidade = 0;
    }

    //PRINCIPAIS METODOS
    public void ligar(){
        if(!ligado){ //se nao estiver ligado
            ligado = true; //liga o carro
            System.out.println("Carro ligado!");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    public void desligar(){
        if (!ligado){
            System.out.println("O carro já está desligado.");
        } else if (marcha == 0 && velocidade == 0) {
            ligado = false;
            System.out.println("Carro desligado!");
        } else {
            System.out.println("Não é possível desligar o carro em movimento ou com marcha engatada!");
        }
    }

    public void acelerar(){
        if (!ligado) {
            System.out.println("O carro está desligado. Ligue o carro primeiro.");
            return;
        }

        if (marcha == 0) {
            System.out.println("Não é possível acelerar em ponto morto!");
            return;
        }

        int VELOCIDADE_MAX = 120;
        if (velocidade < VELOCIDADE_MAX){
            velocidade++;
            if (!verificarLimiteVelocidade()){
                velocidade--;
                System.out.println("Velocidade exce o limite da marcha atual!");
            } else {
                System.out.println("Acelerando... Velocidade atual: " + velocidade + " km/h");
            }
        } else {
            System.out.println("Velocidade máxima atingida!");
        }
    }

    public void desacelerar(){
        if (!ligado) {
            System.out.println("O carro está desligado. Ligue o carro primeiro.");
            return;
        }

        if (velocidade > 0) {
            velocidade--;
            System.out.println("Reduzindo velocidade... Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("O carro já está parado.");
        }
    }

    public void trocarMarcha(int novaMarcha){
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }

        int MARCHA_MAX = 6;
        if (novaMarcha < 0 || novaMarcha > MARCHA_MAX){
            System.out.println("Marcha inválida!");
            return;
        }

        if (Math.abs(novaMarcha - marcha) > 1){
            System.out.println("Não é permitido pular marchas!");
            return;
        }

        marcha = novaMarcha;
        System.out.println("Marcha atual: " + marcha);

    }

    public void virar(String side){
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (velocidade < 1 || velocidade > 40) {
            System.out.println("Para virar, a velocidade deve estar entre 1km/h e 40km/h.");
        } else {
            System.out.println("Virando para " + side + "...");
        }
    }

    public void verificarVelocidade(){
        System.out.println("Velocidade atual: " + velocidade + " km/h | Marcha: " + marcha);
    }

    //REGRAS DE LIMITES
    private boolean verificarLimiteVelocidade(){
        if (marcha == 1) {
            return velocidade >= 0 && velocidade <= 20;
        } else if (marcha == 2) {
            return velocidade >= 21 && velocidade <= 40;
        } else if (marcha == 3) {
            return velocidade >= 41 && velocidade <= 60;
        } else if (marcha == 4) {
            return velocidade >= 61 && velocidade <= 80;
        } else if (marcha == 5) {
            return velocidade >= 81 && velocidade <= 100;
        } else if (marcha == 6) {
            return velocidade >= 101 && velocidade <= 120;
        } else {
            return velocidade == 0;
        }
    }
}
