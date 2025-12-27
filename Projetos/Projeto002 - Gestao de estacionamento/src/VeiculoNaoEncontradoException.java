public class VeiculoNaoEncontradoException extends RuntimeException {
    public VeiculoNaoEncontradoException() {
        super("Veiculo nao encontrado no estacionamento");
    }
}
