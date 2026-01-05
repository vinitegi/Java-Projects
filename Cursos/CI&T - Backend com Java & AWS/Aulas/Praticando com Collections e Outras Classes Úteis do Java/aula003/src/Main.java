import domain.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        users.put("jhon", new User("admin", 25));
        users.put("marry", new User("menager", 35));
        users.put("leo", new User("cliente", 25));
        users.put("jully", new User("seller", 35));
        System.out.println(users);
        System.out.println("=============================");

        users.keySet().forEach(System.out::println);//chama a key (nesse caso, os nomes)
        System.out.println("=============================");
        users.values().forEach(System.out::println);//chama os valores (nesse caso, o id e a idade)
        System.out.println("=============================");

        System.out.println(users.containsKey("jhon"));
        System.out.println(users.containsKey("alejandro"));

        System.out.println("=============================");

        System.out.println(users.containsValue(new User ("menager", 35)));
        System.out.println(users.containsValue(new User ("president", 40)));

        System.out.println("=============================");

        System.out.println(users.remove("marry", new User ("menager", 35)));
        users.keySet().forEach(System.out::println);

    }
}
