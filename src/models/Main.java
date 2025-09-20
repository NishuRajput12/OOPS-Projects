package models;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Sample Users
        Librarian librarian = new Librarian("Admin", "lib123");
        Student student = new Student("John", "stu001");

        while (true) {
            System.out.println("\n===== Welcome to Library System =====");
            System.out.println("1. Login as Librarian");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    handleLibrarian(librarian, library, sc);
                    break;
                case 2:
                    handleStudent(student, library, sc);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void handleLibrarian(Librarian librarian, Library library, Scanner sc) {
        while (true) {
            librarian.showMenu();
            System.out.print("Enter choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    Book newBook = new Book(id, title, author);
                    librarian.addBook(library, newBook);
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();
                    librarian.removeBook(library, removeId);
                    break;
                case 3:
                    library.viewAllBooks();
                    break;
                case 4:
                    System.out.print("Enter search keyword: ");
                    String keyword = sc.nextLine();
                    library.searchBook(keyword);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void handleStudent(Student student, Library library, Scanner sc) {
        while (true) {
            student.showMenu();
            System.out.print("Enter choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    library.viewAllBooks();
                    break;
                case 2:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();
                    library.searchBook(keyword);
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int id = sc.nextInt();
                    Book issueBook = library.findBookById(id);
                    if (issueBook != null) {
                        student.issueBook(issueBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int rid = sc.nextInt();
                    Book returnBook = library.findBookById(rid);
                    if (returnBook != null) {
                        student.returnBook(returnBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    student.showBorrowedBooks();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
