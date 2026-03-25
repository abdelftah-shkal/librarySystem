
public abstract class Book implements Borrowable, Returnable {
    private final String title;
    private boolean isAvailable;

    public Book(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }


    @Override
    public final void borrowBook(User user) {
        if (!isAvailable) {
            System.out.println("\"" + title + "\" is not available.");
            return;
        }
        isAvailable = false;
        onBorrow(user);
    }

    protected abstract void onBorrow(User user);

    @Override
    public void returnBook() {
        isAvailable = true;
        System.out.println("\"" + title + "\" has been returned.");
    }
}
