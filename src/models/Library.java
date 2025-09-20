package models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }

    public void searchBook(String keyword) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching books found.");
        }
    }
}
