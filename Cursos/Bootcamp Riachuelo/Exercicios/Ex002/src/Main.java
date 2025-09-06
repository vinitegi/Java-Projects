import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

//=======================================================================
        //ex001
        System.out.print("Type your number: ");
        var num1 = sc.nextDouble();

        for (int i = 0; i <= 10; i++){
            var result = sc.nextDouble();
            System.out.printf("%s x %s = %s", num1, i, result);
        }

//=======================================================================
        //Ex002

        System.out.print("What's your height and your weight? ");
        var height = sc.nextDouble();
        var weigth = sc.nextDouble();

        var IMC = weigth / Math.pow(height, 2);

        if (IMC <= 18.5){
            System.out.print("Underweight");
        } else if (IMC >= 18.6 && IMC <= 24.9) {
            System.out.print("Normal weight");
        } else if (IMC >= 25 && IMC <= 29.9) {
            System.out.print("Overweight");
        } else if (IMC >= 30 && IMC <= 34.0) {
            System.out.print("Obese - Grade 1");
        } else if (IMC >= 34.1 && IMC <= 39.9) {
            System.out.print("Obese - Grade 2");
        } else if (IMC >= 40) {
            System.out.print("Obese - Grade 3 (you gonna die bro...)");
        }

//=======================================================================
        //Ex003
        System.out.print("Digite o primeiro numero: ");
        int n1 = sc.nextInt();
        System.out.print("Digite o segundo numero (maior que o primeiro): ");
        int n2 = sc.nextInt();
        System.out.print("Digite P para pares ou I para impares: ");
        char opcao = sc.next().toUpperCase().charAt(0);

        for (int i = n2; i >= n1; i--) {
            if (opcao == 'P' && i % 2 == 0) System.out.printf("| %s |", i);
            if (opcao == 'I' && i % 2 != 0) System.out.printf("| %s |", i);
        }

//=======================================================================
         //Ex004
        System.out.print("Digite o numero inicial: ");
        int inicial = sc.nextInt();

        while (true) {
            System.out.print("Digite um numero: ");
            int x = sc.nextInt();

            if (x < inicial) {
                continue;
            }

            if (x % inicial != 0) {
                // Para o loop se o número não for divisível pelo inicial
                System.out.println("Numero invalido, encerrando...");
                break;
            }

            System.out.println("Valido: " + x);
        }
    }
}
