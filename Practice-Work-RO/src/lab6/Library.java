package lab6;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Library {
    private final ReadWriteLock[] bookLocks;
    private final AtomicInteger[] booksWrittenByWritters;
    private final int numberOfBooks;

    public Library(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
        this.bookLocks = new ReentrantReadWriteLock[numberOfBooks];
        this.booksWrittenByWritters = new AtomicInteger[numberOfBooks];
        for (int i = 0; i < numberOfBooks; i++) {
            bookLocks[i] = new ReentrantReadWriteLock();
            booksWrittenByWritters[i] = new AtomicInteger(0);
        }
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public boolean write(int bookId) throws InterruptedException {
        if (booksWrittenByWritters[bookId].get() == 0) {
            bookLocks[bookId].writeLock().lock();
            try {
                if (booksWrittenByWritters[bookId].get() == 0) {
                    System.out.println("Writer " + bookId + "is writing to book " + bookId);
                    Thread.sleep(3000);
                    System.out.println("Writer " + bookId + " has finished writing to book " + bookId);
                    booksWrittenByWritters[bookId].set(1);
                    return true;
                }
            } finally {
                bookLocks[bookId].writeLock().unlock();
            }
        }
        return false;
    }

    public void read(int bookId) throws InterruptedException {
        bookLocks[bookId].readLock().lock();
        try {
            if (booksWrittenByWritters[bookId].get() == 1) {
                System.out.println("Reader is reading the book " + bookId);
                Thread.sleep(2000);
                System.out.println("Reader has finished reading the book " + bookId);
            }
        } finally {
            bookLocks[bookId].readLock().unlock();
        }
    }
}