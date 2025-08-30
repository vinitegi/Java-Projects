import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Quanto eh 2 + 2?");
        var result = scanner.nextInt();
        var isRight = result == 4;
        System.out.printf("O resultado eh 4, voce acertou? (%s)\n", isRight);

        //===================================================================

        System.out.print("Informe o primeiro numero: ");
        var num1 = scanner.nextInt();
        System.out.print("Informe o segundo numero: ");
        var num2 = scanner.nextInt();
        System.out.printf("%s + %s = %s\n", num1, num2, num1 + num2);



    }
}
