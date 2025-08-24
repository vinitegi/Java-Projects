import java.util.Scanner;

public class Main {

    private final static String WELCOME_MESSAGE = "Ola, informe o seu nome";

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);
        var name = scanner.next();
        System.out.println("Informe sua idade");
        var age = scanner.nextInt();

        System.out.printf("Ola %s, sua idade eh de %s", name, age);
    }
}
