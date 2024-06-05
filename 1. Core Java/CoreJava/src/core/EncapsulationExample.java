package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EncapsulationExample {
	
	/* 
	 access modifiers to restrict access to the fields of a class, 
	 and using public methods (getters and setters) to access and modify those fields. 
	 */
	
    private static final Logger logger = LogManager.getLogger(EncapsulationExample.class);

    public static void main(String[] args) {
        Book book = new Book("St. Clare's", "Enid Blyton", 1941);

        // Accessing book details using getters
        logger.info("Title: " + book.getTitle());
        logger.info("Author: " + book.getAuthor());
        logger.info("Year Published: " + book.getYearPublished());

        // Modifying book details using setters
        book.setTitle("Malory Towers");
        book.setYearPublished(1946);

        // Accessing updated book details using getters
        logger.info("Updated Title: " + book.getTitle());
        logger.info("Updated Year Published: " + book.getYearPublished());
    }
}

class Book {
    // Private fields
    private String title;
    private String author;
    private int yearPublished;

    // Constructor
    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for yearPublished
    public int getYearPublished() {
        return yearPublished;
    }

    // Setter for yearPublished
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
}
