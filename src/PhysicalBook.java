public class PhysicalBook extends Book {
    public PhysicalBook(String title) { super(title); }

    @Override
    protected void onBorrow(User user) {
        System.out.println("Physical Book: \"" + getTitle() + "\" borrowed by " + user.getName() + ".");
    }
}
