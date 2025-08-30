import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Digite um numero: ");
        var num = scanner.nextInt();

        if (num % 2 == 0){
            System.out.print("O numero eh par");
        } else {
            System.out.print("O numero eh impar");
        }
    }
}
