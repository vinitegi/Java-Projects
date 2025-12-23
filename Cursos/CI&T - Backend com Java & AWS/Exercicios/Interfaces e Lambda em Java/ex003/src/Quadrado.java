public class Quadrado implements FiguraGeometrica{

    private final double lado;

    public Quadrado(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("Lado deve ser positivo e maior que zero");
        }
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
