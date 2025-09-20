package models;


public class Librarian extends User {

    public Librarian(String name, String userId) {
        super(name, userId);
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println("Book added.");
    }

    public void removeBook(Library library, int bookId) {
        library.removeBook(bookId);
        System.out.println("Book removed.");
    }

    @Override
    public void showMenu() {
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. View All Books");
        System.out.println("4. Search Book");
        System.out.println("5. Logout");
    }
}
