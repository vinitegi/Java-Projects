public class RelogioAmericano extends Relogio {

    @Override
    public void setHora(int hora) {
        if (hora < 1 || hora > 12) {
            throw new IllegalArgumentException(
                    "Relógio americano só aceita horas de 1 a 12"
            );
        }
        this.hora = hora;
    }

    @Override
    public void atualizarHorario(Relogio outroRelogio) {
        int horaRecebida = outroRelogio.getHora();

        // Conversão de 24h para 12h
        if (horaRecebida == 0) {
            horaRecebida = 12;
        } else if (horaRecebida > 12) {
            horaRecebida -= 12;
        }

        setHora(horaRecebida);
        setMinuto(outroRelogio.getMinuto());
        setSegundo(outroRelogio.getSegundo());
    }
}