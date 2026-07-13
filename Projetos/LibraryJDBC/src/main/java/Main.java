import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//    public static int showMenu(Scanner input) {
//
//        System.out.println("\n===== BOOK MANAGEMENT SYSTEM =====");
//        System.out.println("1 - Add Book");
//        System.out.println("2 - List Books");
//        System.out.println("3 - Search Book");
//        System.out.println("4 - Borrow Book");
//        System.out.println("5 - Return Book");
//        System.out.println("0 - Exit");
//        System.out.print("Choice: ");
//
//        return input.nextInt();
//    }

    public static void main(String[] args) {
        try {

            Connection connection =
                    DatabaseConnection.getConnection();
            String sql = "SELECT * FROM books";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                boolean available =
                        resultSet.getBoolean("available");

                System.out.println("ID: " + id);
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Available: " + available);
                System.out.println("---------------------");
            }

            System.out.println("Connected successfully!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Connection error!");
            e.printStackTrace();

        }
    }
}