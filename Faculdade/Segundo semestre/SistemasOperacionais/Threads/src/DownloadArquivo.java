public class DownloadArquivo  extends  Thread{
    private String nomeArquivo;

    public DownloadArquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void run(){
        try {
            for (int i = 10; i <= 100; i += 10){
                Thread.sleep(1000);

                System.out.println(
                        nomeArquivo +
                                " - " +
                                i +
                                " MB baixados"
                );
            }

            System.out.println(
                    nomeArquivo +
                            " - Download concluído!"
            );
        } catch (InterruptedException e){
            System.out.println(
                    "Erro no download de " +
                            nomeArquivo
            );
        }
    }
}
