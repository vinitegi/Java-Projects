import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Veiculo {
    private String placa;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public Veiculo(String Placa){
        this.placa = Placa;
        this.entrada = LocalDateTime.now();
    }

    public abstract double calcularValor();

    public long getTempoEmMinuto(){
        return Duration.between(entrada, saida).toMinutes();
    }

    public void registrarSaida(){
        this.saida = LocalDateTime.now();
    }

    public String getPlaca() {
        return placa;
    }

}
