import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner (System.in);

        System.out.println("Digite a sua nota: ");
        var nota = scanner.nextInt();

        if (nota >= 5){
            System.out.println("Voce foi aprovado!");
        } else {
            System.out.println("Voce foi reprovado!");
        }
    }
}
