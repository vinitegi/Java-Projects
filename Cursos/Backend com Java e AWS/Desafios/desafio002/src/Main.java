import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê a entrada do usuário
        // Diferente do desafio anterior, NÃO usamos .toLowerCase() aqui
        // pois o enunciado exige validação estrita (ec2 minúsculo é inválido).
        String codigo = scanner.nextLine();

        // Verifica exatamente se o código é igual a "EC2"
        switch (codigo) {
            case "EC2" -> System.out.println("EC2");

            // Verifica exatamente se o código é igual a "S3"
            case "S3" -> System.out.println("S3");

            // Verifica exatamente se o código é igual a "Lambda"
            case "Lambda" -> System.out.println("Lambda");

            // Se não for nenhum dos anteriores
            default -> System.out.println("Codigo invalido");
        }

        //OU
        /*
        if (codigo.equals("EC2")) {
            System.out.println("EC2");
        }
        else if (codigo.equals("S3")) {
            System.out.println("S3");
        }
        else if (codigo.equals("Lambda")) {
            System.out.println("Lambda");
        }
        else {
            System.out.println("Codigo invalido");
        }
         */

        scanner.close();
    }
}