public abstract class Relogio {
    protected int hora;
    protected int minuto;
    protected int segundo;

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("Hora invalida");
        }
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("Minuto inválido");
        }
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("Minuto inválido");
        }
        this.segundo = segundo;
    }

    public String getHorarioFormatado(){
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    public abstract void atualizarHorario(Relogio outroRelogio);

}
