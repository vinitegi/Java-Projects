import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Digite seu salario: ");
        var salario = scanner.nextDouble();

        System.out.print("Digite sua nota (0 a 10): ");
        var nota = scanner.nextDouble();

        double aumento = 0;

        if (nota <= 2) {
            aumento = 0;
        } else if (nota <= 4) {
            aumento = 0.05;
        } else if (nota <= 6) {
            aumento = 0.10;
        } else if (nota <= 8) {
            aumento = 0.15;
        } else if (nota <= 10) {
            aumento = 0.20;
        }

        var salarioFinal = salario + (salario * aumento);

        System.out.println("Salario original: R$ " + salario);
        System.out.println("Salario com aumento: R$ " + salarioFinal);
    }
}
