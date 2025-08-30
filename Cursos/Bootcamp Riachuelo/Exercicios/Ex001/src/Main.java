import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        //Ex001
        System.out.println("Digite o seu nome: ");
        var name = scanner.nextLine();
        System.out.println("Digite o ano de nascimento: ");
        var ano = scanner.nextInt();

        System.out.printf("Olá, %s. Você possui %s anos de idade!", name, 2025 - ano);

        //Ex002
        System.out.println("Digite o lado do quadrado: ");
        var lado = scanner.nextDouble();
        var area = lado * lado;
        System.out.printf("A area do quadrado é %s U.M.", area);

        //Ex003
        System.out.println("Digite o lado do retangulo: ");
        var ladoRetangulo = scanner.nextDouble();
        System.out.println("Digite a altura do retangulo: ");
        var alturaRetangulo = scanner.nextDouble();
        var areaRetangulo = alturaRetangulo * ladoRetangulo;
        System.out.printf("A area do quadrado é %s U.M.", areaRetangulo);

        //Ex004
        System.out.println("Digite a idade da pessoa 1 e 2: ");
        var pessoa1 = scanner.nextInt();
        var pessoa2 = scanner.nextInt();
        System.out.printf("A diferença de idade é de %s anos", (pessoa2 - pessoa1) * (-1));
    }
}