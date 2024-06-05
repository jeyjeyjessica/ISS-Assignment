package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExample2 {
    private static final Logger logger = LogManager.getLogger(SortingExample2.class);

    public static void main(String[] args) {
        // Define Book class
        class Book implements Comparable<Book> {
            private String name;
            private int rating;
            private int year;

            public Book(String name, int rating, int year) {
                this.name = name;
                this.rating = rating;
                this.year = year;
            }

            @Override
            public int compareTo(Book other) {
                return this.name.compareTo(other.name);
            }

            @Override
            public String toString() {
                return "Book{" +
                        "name='" + name + '\'' +
                        ", rating=" + rating +
                        ", year=" + year +
                        '}';
            }
        }

        // Create a list of Book objects
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Great Gatsby", 4, 1925));
        books.add(new Book("To Kill a Mockingbird", 5, 1960));
        books.add(new Book("1984", 4, 1949));
        books.add(new Book("Pride and Prejudice", 5, 1813));
        books.add(new Book("The Catcher in the Rye", 3, 1951));

        // Logging the unsorted list of books
        logger.info("Unsorted List of Books: " + books);

        // Sorting using Comparable interface (by book name)
        Collections.sort(books);
        // Logging the sorted list of books
        logger.info("Sorted List of Books using Comparable (by name): " + books);

        // Sorting using Comparator interface (by year)
        Collections.sort(books, Comparator.comparingInt(book -> book.year));
        // Logging the sorted list of books by year
        logger.info("Sorted List of Books using Comparator (by year): " + books);
    }
}

