public class Main {
    static void main() {
        DownloadArquivo arq1 = new DownloadArquivo("Arquivo 1");
        DownloadArquivo arq2 = new DownloadArquivo("Arquivo 2");
        DownloadArquivo arq3 = new DownloadArquivo("Arquivo 3");
        DownloadArquivo arq4 = new DownloadArquivo("Arquivo 4");
        DownloadArquivo arq5 = new DownloadArquivo("Arquivo 5");

        arq1.start();
        arq2.start();
        arq3.start();
        arq4.start();
        arq5.start();

        try {
            arq1.join();
            arq2.join();
            arq3.join();
            arq4.join();
            arq5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
