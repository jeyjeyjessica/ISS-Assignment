package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractionExample {
    private static final Logger logger = LogManager.getLogger(AbstractionExample.class);

    public static void main(String[] args) {
        FictionNovel novel1 = new FantasyNovel("The Hobbit", "J.R.R. Tolkien");
        FictionNovel novel2 = new MysteryNovel("Sherlock Holmes", "Sir Arthur Conan Doyle");

        logger.info(novel1.getDetails());
        logger.info(novel1.getGenre());

        logger.info(novel2.getDetails());
        logger.info(novel2.getGenre());
    }
}

// Abstract class FictionNovel
abstract class FictionNovel {
    private String title;
    private String author;

    public FictionNovel(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getDetails() {
        return "Title: " + title + ", Author: " + author;
    }

    // Abstract method
    public abstract String getGenre();
}

// Subclass FantasyNovel
class FantasyNovel extends FictionNovel {
    FantasyNovel(String title, String author) {
        super(title, author);
    }

    @Override
    public String getGenre() {
        return "Genre: Fantasy";
    }
}

// Subclass MysteryNovel
class MysteryNovel extends FictionNovel {
    MysteryNovel(String title, String author) {
        super(title, author);
    }

    @Override
    public String getGenre() {
        return "Genre: Mystery";
    }
}

