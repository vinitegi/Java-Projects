import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        //ex001
        System.out.print("Digite um numero");
        int num = sc.nextInt();

        for (int i = 0; i <= num; i++){
            System.out.printf("| %s |", i);
        }

        //ex002
        int saida = 999;
        do {
            System.out.print("Digite um número (999 para sair): ");
            num = sc.nextInt();
        } while (num != saida);

        //ex003
        int soma = 0;
        while (soma <= 1000) {
            System.out.print("Digite um valor para somar: ");
            int valor = sc.nextInt();
            soma += valor;
        }
        System.out.println("Soma final: " + soma);

        //ex004
        int sub = 0;
        while (sub >= -1000) {
            System.out.print("Digite um valor para subtrair: ");
            int valor = sc.nextInt();
            sub -= valor;
        }
        System.out.println("Resultado final: " + sub);

    }
}

