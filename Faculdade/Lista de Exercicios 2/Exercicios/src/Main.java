import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        //Ex001
        for (int i = 1; i <= 100; i++) {
            if (i == 50) {
                System.out.printf("| %s \n|", i);
            } else {
                System.out.printf("| %s |", i);
            }
        }

        System.out.print("\n\n");

        //Ex002
        for (int i = 100; i >= 1; i--) {
            if (i == 50) {
                System.out.printf("| %s \n|", i);
            } else {
                System.out.printf("| %s |", i);
            }
        }

        System.out.print("\n\n");

        //Ex003
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                if (i == 50) {
                    System.out.printf("| %s \n|", i);
                } else {
                    System.out.printf("| %s |", i);
                }
            }
        }

        System.out.print("\n\n");

        //Ex004
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.printf("| %d |", i);
            }
        }

        System.out.print("\n\n");

        //Ex005
        double Soma = 0.0;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Dgite o numero %s", i+1);
            var num = sc.nextDouble();
            Soma += num;
        }
        System.out.printf("Soma = %s", Soma);

        System.out.print("\n\n");

        //Ex006
        System.out.print("Digite a altura do triangulo: ");
        int a = sc.nextInt();

        for(int i = 1; i <= a; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.print("\n\n");

        //Ex006
        System.out.print("Digite a altura do triangulo: ");
        int b = sc.nextInt();

        for(int i = 1; i <= b; i++){
            //Define a quantidade de espaços
            for (int k = 0; k < b - i; k++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.print("\n\n");

        //Ex007
        System.out.print("Digite a altura do triangulo: ");
        int c = sc.nextInt();

        for (int i = c; i >= 1; i--) {
            for (int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.print("\n\n");

        //Ex008
        System.out.print("Digite a altura do triangulo: ");
        int d = sc.nextInt();

        for (int i = d; i >= 1; i--){
            for (int j = 0; j < d - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
