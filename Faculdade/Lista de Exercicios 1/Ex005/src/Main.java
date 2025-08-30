import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();

        double media = (nota1 + nota2) / 2;

        if (media > 5) {
            System.out.println("Aprovado!");
        } else {
            System.out.println("Reprovado! Receba mais uma nota.");
            System.out.print("Digite a terceira nota: ");
            double nota3 = scanner.nextDouble();

            double maiorNota = Math.max(nota1, nota2);
            //vai armazenar o maior valor entre as notas na variavel maiorNota

            media = (maiorNota + nota3) / 2;
            if (media > 5) {
                System.out.println("Aprovado!");
            } else {
                System.out.println("Reprovado!");
            }
        }
        }
    }
