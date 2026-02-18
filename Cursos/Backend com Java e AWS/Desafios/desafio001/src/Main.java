import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine().toLowerCase();

        // 1. RDS: Palavras-chave específicas e sem muita ambiguidade
        if (texto.contains("banco de dados") || texto.contains("relacional")) {
            System.out.println("RDS");
        }
        // 2. Lambda: "sem servidor" e "funcoes".
        // REMOVIDO "executar" pois gerava conflito com EC2 (servidores também executam coisas).
        // IMPORTANTE: Checar "sem servidor" ANTES de checar "servidor" (EC2) abaixo.
        else if (texto.contains("sem servidor") || texto.contains("funcoes")) {
            System.out.println("Lambda");
        }
        // 3. EC2: "servidor" ou "virtual"
        else if (texto.contains("servidor") || texto.contains("virtual")) {
            System.out.println("EC2");
        }
        // 4. S3: Adicionado "arquivos", "imagens", "videos" para cobrir a descrição e os exemplos
        else if (texto.contains("armazenar") || texto.contains("armazenamento") ||
                texto.contains("arquivos") || texto.contains("imagens") || texto.contains("videos")) {
            System.out.println("S3");
        }
        else {
            System.out.println("Servico desconhecido");
        }

        scanner.close();
    }
}