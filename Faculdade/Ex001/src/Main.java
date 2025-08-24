import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //entrada dos dados
        System.out.print("Digite o primeiro número inteiro: ");
        int num1 = sc.nextInt();

        System.out.print("Digite o segundo número inteiro: ");
        int num2 = sc.nextInt();

        //contas
        int soma = num1 + num2;
        int subtracao = num1 - num2;
        int multiplicacao = num1 * num2;

        double divisao = 0;
        if(num2 != 0){
            divisao = (double) num1 / num2; //muda pra double -> mostra as casas decimais, caso haja
        } else {
            System.out.println("Divisão: não é possível dividir por zero!");
        }

        System.out.println("\nResultados:");
        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);
        if (num2 != 0) {
            System.out.println("Divisão: " + divisao);
        }
    }
}
