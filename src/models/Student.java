package models;


import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private List<Book> borrowedBooks = new ArrayList<>();

    public Student(String name, String userId) {
        super(name, userId);
    }

    public void issueBook(Book book) {
        if (!book.isIssued()) {
            borrowedBooks.add(book);
            book.setIssued(true);
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book is already issued.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setIssued(false);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("You don't have this book.");
        }
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books.");
        } else {
            System.out.println("Borrowed Books:");
            for (Book b : borrowedBooks) {
                System.out.println(b);
            }
        }
    }

    @Override
    public void showMenu() {
        System.out.println("1. View All Books");
        System.out.println("2. Search Book");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. My Borrowed Books");
        System.out.println("6. Logout");
    }
}
