import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        var num1 = scanner.nextDouble();

        System.out.print("Digite o segundo numero: ");
        var num2 = scanner.nextDouble();

        System.out.print("Digite o operador (+, -, *, /): ");
        var operador = scanner.next().charAt(0);

        switch (operador) {
            case '+':
                System.out.println("Resultado: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Resultado: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Resultado: " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0)
                    System.out.println("Resultado: " + (num1 / num2));
                else
                    System.out.println("Erro: divisao por zero nao e permitida.");
                break;
            default:
                System.out.println("Operador invalido!");
        }
    }
}
