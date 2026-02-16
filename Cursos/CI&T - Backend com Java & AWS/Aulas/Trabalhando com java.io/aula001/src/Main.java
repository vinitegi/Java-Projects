import persistence.FilePersistence;
import persistence.IOFilePersistence;
import persistence.NIOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new NIOFilePersistence("user.csv");

        System.out.println(persistence.write("bianca;bianca@bia.com;22/09/1997"));
        System.out.println("========================");
        System.out.println(persistence.write("bernado;bernado@bernardo.com;28/11/1999"));
        System.out.println("========================");
        System.out.println(persistence.write("ricardo;ricardo@ricardo.com;12/01/2000"));
        System.out.println("========================");

        System.out.println(persistence.findAll());
        System.out.println("========================");

        System.out.println(persistence.findBy("bia@"));
        System.out.println("========================");
        System.out.println(persistence.findBy("tegi@"));
        System.out.println("========================");



    }
}
