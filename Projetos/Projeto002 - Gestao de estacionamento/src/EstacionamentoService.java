import java.util.ArrayList;
import java.util.List;

public class EstacionamentoService {

    protected List<Veiculo> veiculosAtivos = new ArrayList<>();

    public void entradaVeiculo(Veiculo veiculo){
        veiculosAtivos.add(veiculo);
    }

    public double saidaVeiculo(String placa){
        Veiculo v = buscarPorPlaca(placa);
        v.registrarSaida();
        veiculosAtivos.remove(v);
        return v.calcularValor();
    }

    public Veiculo buscarPorPlaca(String placa){
        return veiculosAtivos.stream().filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst().orElseThrow(VeiculoNaoEncontradoException::new);
    }

    public List<Veiculo> listarVeiculos(){
        return veiculosAtivos;
    }
}
