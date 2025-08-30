import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu salario: ");
        var salario = scanner.nextDouble();

        double desconto = 0;

        if (salario < 1000) {
            desconto = 0;
        } else if (salario < 2000) {
            desconto = 0.07;
        } else if (salario < 3000) {
            desconto = 0.15;
        } else if (salario < 4000) {
            desconto = 0.22;
        } else {
            desconto = 0.29;
        }

        var valorDescontado = salario * desconto;
        var salarioLiquido = salario - valorDescontado;

        System.out.println("Valor do imposto: R$ " + valorDescontado);
        System.out.println("Salario liquido: R$ " + salarioLiquido);

        scanner.close();
    }
}
