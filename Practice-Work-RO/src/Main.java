//import package classes for necessary laboratory


import lab6.*;


public class Main {
    public static void main(String[] args) {
        int numBooks = 20;
        int numWriters = 7;
        int numReaders = 14;

        Library library = new Library(numBooks);

        Thread[] writerThreads = new Thread[numWriters];
        for (int i = 0; i < numWriters; i++) {
            Writer writer = new Writer(library, i);
            writerThreads[i] = new Thread(writer);
            writerThreads[i].start();
        }

        Thread[] readerThreads = new Thread[numReaders];
        for (int i = 0; i < numReaders; i++) {
            Reader reader = new Reader(library, numBooks);
            readerThreads[i] = new Thread(reader);
            readerThreads[i].start();
        }

        for (Thread writerThread : writerThreads) {
            try {
                writerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread readerThread : readerThreads) {
            try {
                readerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Menu menu = new Menu();
    }
}