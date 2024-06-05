package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InterfaceExample {
    private static final Logger logger = LogManager.getLogger(InterfaceExample.class);

    public static void main(String[] args) {
        Fiction novel1 = new FantasyNovel1("The Hobbit", 4.8);
        Fiction novel2 = new MysteryNovel1("Sherlock Holmes", 4.6);

        logger.info(novel1.getName());
        logger.info("Rating: " + novel1.getRating());

        logger.info(novel2.getName());
        logger.info("Rating: " + novel2.getRating());
    }
}

// Interface Fiction
interface Fiction {
    String getName();
    double getRating();
}

// Class implementing Fiction interface
class FantasyNovel1 implements Fiction {
    private String name;
    private double rating;

    public FantasyNovel1(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return "Name: " + name;
    }

    @Override
    public double getRating() {
        return rating;
    }
}

// Class implementing Fiction interface
class MysteryNovel1 implements Fiction {
    private String name;
    private double rating;

    public MysteryNovel1(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return "Name: " + name;
    }

    @Override
    public double getRating() {
        return rating;
    }
}

