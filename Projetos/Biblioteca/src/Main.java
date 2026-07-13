import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        int opt;
        do {
            System.out.println("\n===== BOOK MANAGEMENT SYSTEM =====");
            System.out.println("1 - Add Book");
            System.out.println("2 - List Books");
            System.out.println("3 - Search Book");
            System.out.println("4 - Borrow Book");
            System.out.println("5 - Return Book");
            System.out.println("0 - Exit");
            System.out.print("Choice: ");
            opt = input.nextInt();
            input.nextLine();

            switch (opt) {
                case 1:
                    System.out.println("Enter Book Title: ");
                    String title = input.nextLine();

                    System.out.println("Enter Book Author: ");
                    String author = input.nextLine();

                    Book book = new Book(title, author);
                    books.add(book);
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("There are no books in the system");
                    } else {
                        System.out.println("\n === BOOK LIST ===");
                        for (Book bookList : books) {
                            System.out.println(bookList);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Book Title: ");
                    String searchTitle = input.nextLine();
                    Boolean found = false;

                    for (Book bookList : books) {
                        if (bookList.getTitle().equalsIgnoreCase(searchTitle)) {
                            System.out.println(bookList);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Book Not Found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Book Title: ");
                    String borrowTitle = input.nextLine();
                    boolean bookFound = false;
                    for (Book bookList : books) {
                        if (bookList.getTitle().equalsIgnoreCase(borrowTitle)) {
                            bookFound = true;

                            if (bookList.getAvailable() == AvailableStatus.AVAILABLE) {
                                bookList.setAvailable(AvailableStatus.UNAVAILABLE);
                                System.out.println("Book borrowed successfully!");
                            } else {
                                System.out.println("Book is already borrowed!");
                            }
                        }
                    }
                    if (!bookFound) {
                        System.out.println("Book not found");
                    }

                    break;

                case 5:
                    System.out.print("Enter Book Title: ");
                    String returnTitle = input.nextLine();
                    boolean foundReturn = false;

                    for (Book bookList : books) {
                        if (bookList.getTitle().equalsIgnoreCase(returnTitle)) {
                            foundReturn = true;
                            if (bookList.getAvailable() == AvailableStatus.UNAVAILABLE) {
                                bookList.setAvailable(AvailableStatus.AVAILABLE);
                                System.out.println("Book returned successfully!");
                            } else {
                                System.out.println("Book is already available!");
                            }
                        }
                    }

                    if (!foundReturn) {
                        System.out.println("Book not found");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (opt != 0);
    }
}
