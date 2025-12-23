public class Main {
    public static void main(String[] args) {
        FiguraGeometrica q = new Quadrado(4);
        FiguraGeometrica r = new Retangulo(3, 4);
        FiguraGeometrica c = new Circulo(2);

        System.out.println("Área do Quadrado: " + q.calcularArea());
        System.out.println("Área do Retângulo: " + r.calcularArea());
        System.out.println("Área do Círculo: " + c.calcularArea());
    }
}
