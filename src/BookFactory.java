public class BookFactory {
    public enum BookType { PHYSICAL, EBOOK, HISTORICAL }

    public static Book create(BookType type, String title) {
        return switch (type) {
            case PHYSICAL   -> new PhysicalBook(title);
            case EBOOK      -> new EBook(title);
            case HISTORICAL -> new HistoricalBook(title);
        };
    }
}
