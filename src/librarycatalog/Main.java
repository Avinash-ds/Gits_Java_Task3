package librarycatalog;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryCatalog libraryCatalog = new LibraryCatalog();

        while (true) {
            System.out.println("Library Catalog");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List Books");
            System.out.println("4. Search by Title");
            System.out.println("5. Search by Author");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    long ISBN = scanner.nextLong();
                    System.out.print("Enter publication year: ");
                    int publicationYear = scanner.nextInt();
                    scanner.nextLine();
                    Book newBook = new Book(title, author, ISBN, publicationYear);
                    libraryCatalog.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter the book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    List<Book> booksToRemove = libraryCatalog.searchByTitle(removeTitle);
                    if (!booksToRemove.isEmpty()) {
                        // Assuming user wants to remove the first matching book found.
                        Book bookToRemove = booksToRemove.get(0);
                        libraryCatalog.removeBook(bookToRemove);
                        System.out.println("Book removed successfully!");
                    } else {
                        System.out.println("Book not found in the catalog.");
                    }
                    break;

                case 3:
                    List<Book> bookList = libraryCatalog.listBooks();
                    System.out.println("Book List:");
                    for (int i = 0; i < bookList.size(); i++) {
                        System.out.println((i + 1) + ". " + bookList.get(i));
                    }
                    break;

                case 4:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> foundByTitle = libraryCatalog.searchByTitle(searchTitle);
                    if (!foundByTitle.isEmpty()) {
                        System.out.println("Found the following books by title:");
                        for (Book book : foundByTitle) {
                            System.out.println(book);
                        }
                    } else {
                        System.out.println("No books found by title.");
                    }
                    break;

                case 5:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    List<Book> foundByAuthor = libraryCatalog.searchByAuthor(searchAuthor);
                    if (!foundByAuthor.isEmpty()) {
                        System.out.println("Found the following books by author:");
                        for (Book book : foundByAuthor) {
                            System.out.println(book);
                        }
                    } else {
                        System.out.println("No books found by author.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
