import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var value = Stream.of("Maria", "John", "Mario", "Ana", "Marcelo", "Antonio")
                .filter(name -> name.endsWith("o"))//posicionamento importa
                .limit(2)
                .toList();


        System.out.println(value);

    }
}
