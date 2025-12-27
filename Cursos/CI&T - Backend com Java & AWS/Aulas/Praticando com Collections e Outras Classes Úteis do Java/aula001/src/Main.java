import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        int[] codes = new int[2];
        codes[0] = 1;
        codes[1] = 2;

        List<Integer> codes2 = new ArrayList<>();
        codes2.add(codes[0]);
        codes2.add(codes[1]);

        codes2.forEach(System.out::println); //codes2.forEach(code -> System.out.println(code));
        System.out.println("======\n");

        codes2.add(31243);
        codes2.add(4574567);
        codes2.forEach(System.out::println);

    }
}
