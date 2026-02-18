import domain.Contatact;
import domain.ContatactType;
import domain.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static domain.ContatactType.EMAIL;
import static domain.ContatactType.PHONE;
import static domain.Sex.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(generateUser());

        var values = users.stream()
                .flatMap(u -> u.contacts().stream())
                .toList();

        values.forEach(System.out::println);
    }

    private static List<User> generateUser(){
        var contacts1 = List.of(
                new Contatact("(19)90665-8104", PHONE),
                new Contatact("john@gmail.com", EMAIL)
        );
        var contacts2 = List.of(
                new Contatact("(16)99687-4356", PHONE)
        );
        var contacts3 = List.of(
                new Contatact("lucas@outlook.com", EMAIL)
        );
        var contacts4 = List.of(
                new Contatact("andreia@outlook.com", EMAIL),
                new Contatact("andreia@gmail.com", EMAIL)
        );
        var contacts5 = List.of(
                new Contatact("(31)97784-6243", PHONE),
                new Contatact("(32)89941-5987", PHONE)
        );

        var users1 = new User("John", 26, MALE, new ArrayList<>(contacts1));
        var users2 = new User("Maria", 28, FEMALE, new ArrayList<>(contacts2));
        var users3 = new User("Lucas", 24, MALE, new ArrayList<>(contacts3));
        var users4 = new User("Andreia", 48, FEMALE, new ArrayList<>(contacts4));
        var users5 = new User("Marcos", 50, MALE, new ArrayList<>(contacts5));
        var users6 = new User("Vitor", 37, MALE, new ArrayList<>());



        return List.of(users1, users2, users3, users4, users5,  users6);
    }
}
