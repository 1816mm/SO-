package lab6;

public class Writer implements Runnable {
    private final Library library;
    private final int bookId;

    public Writer(Library library, int bookId) {
        this.library = library;
        this.bookId = bookId;
    }

    public void run() {
        try {
            library.write(bookId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}