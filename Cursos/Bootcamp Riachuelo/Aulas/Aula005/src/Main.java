import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var male = new Person();

        male.setName("Jhon");
        male.setAge(19);

        System.out.println(male.getName());
        System.out.println(male.getAge());
    }
}
