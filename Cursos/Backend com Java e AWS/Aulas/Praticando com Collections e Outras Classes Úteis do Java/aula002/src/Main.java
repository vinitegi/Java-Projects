import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(new User(1, "Jao"));
        users.add(new User(2, "Juan"));
        users.add(new User(3, "Maria"));
        users.add(new User(4, "Pedro"));
        users.add(new User(5, "Lucas"));

        System.out.println(users.contains(new User(2, "Juan")));

        users.forEach(System.out::println);
    }
}
