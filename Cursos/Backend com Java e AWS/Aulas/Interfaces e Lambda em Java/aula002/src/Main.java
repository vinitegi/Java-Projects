import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(new User("Maria", 21),  new User("John", 32),
                new User("Anna", 40), new User("Julia", 19));

        users.forEach(System.out::println);

    }
}

