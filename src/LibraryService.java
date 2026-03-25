import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private static LibraryService instance;
    private final List<Book> books = new ArrayList<>();

    private LibraryService() {}

    public static LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public void borrowBook(String title, User user) {
        Book book = findBook(title);
        if (book != null) book.borrowBook(user);
        else System.out.println("Book \"" + title + "\" not found.");
    }

    public void returnBook(String title) {
        Book book = findBook(title);
        if (book != null) book.returnBook();
        else System.out.println("Book \"" + title + "\" not found.");
    }
}
