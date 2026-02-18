public class RelogioBrasileiro extends Relogio {

    @Override
    public void atualizarHorario(Relogio outroRelogio){
        setHora(outroRelogio.getHora());
        setMinuto(outroRelogio.getMinuto());
        setSegundo(outroRelogio.getSegundo());
    }
}
