package lab6;

public class Reader implements Runnable {
    private final Library library;
    private final int numberOfBooks;

    public Reader(Library library, int numberOfBooks) {
        this.library = library;
        this.numberOfBooks = numberOfBooks;
    }

    public void run() {
        for (int bookId = 0; bookId < numberOfBooks; bookId++) {
            try {
                library.read(bookId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}