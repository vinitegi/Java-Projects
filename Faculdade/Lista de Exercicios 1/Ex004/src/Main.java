import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        double[] num = new double[4];
        for (int i = 0; i < 4; i++) {
            System.out.printf("Digite o numero %d: ", i + 1);
            num[i] = scanner.nextDouble();
        }

        var maior = num[0];
        var menor = num[0];
        for (int i = 0; i < num.length; i++){
            if (num[i] > maior){
                maior = num[i];
            }
            if (num[i] < menor){
                menor = num[i];
            }
        }
        System.out.println("O maior numero eh: " + maior);
        System.out.println("O menor numero eh: " + menor);
    }
}
