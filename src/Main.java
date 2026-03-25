public class Main {
    public static void main(String[] args) {
        LibraryService library = LibraryService.getInstance();

        library.addBook(BookFactory.create(BookFactory.BookType.PHYSICAL,   "Harry Potter"));
        library.addBook(BookFactory.create(BookFactory.BookType.EBOOK,      "Lord of the Rings"));
        library.addBook(BookFactory.create(BookFactory.BookType.HISTORICAL, "Sapiens"));

        User john = new User("John", true);
        User jane = new User("Jane", false);

        library.borrowBook("Harry Potter", john);

        library.borrowBook("Harry Potter", jane); 

        library.borrowBook("Lord of the Rings", john);

        library.returnBook("Harry Potter");
        library.borrowBook("Harry Potter", jane);

        library.borrowBook("Sapiens", john);

        library.borrowBook("Unknown Book", john);

        LibraryService same = LibraryService.getInstance();
        System.out.println("Same instance: " + (library == same)); // true
    }
}
