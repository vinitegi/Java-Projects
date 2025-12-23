public class Retangulo implements FiguraGeometrica{

    private final double lado;
    private final double altura;

    public Retangulo(double lado, double altura){
        if (lado <= 0 || altura <= 0){
            throw new IllegalArgumentException("As medidas devem ser positivas e maior que zero");
        }
        this.lado = lado;
        this.altura = altura;
    }



    @Override
    public double calcularArea() {
        return lado * altura;
    }
}
