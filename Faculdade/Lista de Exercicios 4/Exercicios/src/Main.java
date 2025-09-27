import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ex001
        String[] nomes = new String[5];
        for (int i = 0; i < nomes.length; i++){
            System.out.printf("Digite o nome %s:", i + 1);
            nomes[i] = sc.next();
        }
        for (String nome : nomes){ //cria uma variavel temporaria 'nome' para armazenar a posicao atual do array nomes[]
            System.out.printf("Nome: %s\n", nome);
        }

        //ex002
        Double[] notas = new Double[10];
        for (int i = 0; i < notas.length; i++) {
            System.out.printf("Digite a nota %s:", i + 1);
            notas[i] = sc.nextDouble();
        }
        System.out.println("Notas digitadas:");
        for (double nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.println();

        //ex003
        double maior = notas[0], menor = notas[0], media = 0;
        for (double nota : notas) {
            if (nota > maior) maior = nota;
            if (nota < menor) menor = nota;
            media += nota;
        }
        media /= notas.length;

        System.out.println("Maior nota: " + maior);
        System.out.println("Menor nota: " + menor);
        System.out.println("Média: " + media);

    }
}
