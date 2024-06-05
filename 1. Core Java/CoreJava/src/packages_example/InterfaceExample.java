package packages_example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import package_example2.FantasyNovel;
import package_example2.Fiction;
import package_example2.MysteryNovel;

public class InterfaceExample {
    private static final Logger logger = LogManager.getLogger(InterfaceExample.class);

    public static void main(String[] args) {
        Fiction novel1 = new FantasyNovel("The Hobbit", 4.8);
        Fiction novel2 = new MysteryNovel("Sherlock Holmes", 4.6);

        logger.info("Name: " + novel1.getName() + ", Rating: " + novel1.getRating());
        logger.info("Name: " + novel2.getName() + ", Rating: " + novel2.getRating());
    }
}

