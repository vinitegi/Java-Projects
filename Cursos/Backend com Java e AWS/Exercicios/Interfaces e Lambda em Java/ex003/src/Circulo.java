public class Circulo implements FiguraGeometrica{

    private final double raio;

    public Circulo(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("O raio deve ser positivo e maior que zero");
        }
        this.raio = raio;
    }


    @Override
    public double calcularArea() {
        return Math.PI * (raio * raio);
    }
}
