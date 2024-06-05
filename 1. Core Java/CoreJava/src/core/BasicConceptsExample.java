package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicConceptsExample {
    
    private static final Logger logger = LogManager.getLogger(BasicConceptsExample.class);

    public static class MarvelCharacter {
        // Instance variables (state)
        private String name;
        private String alias;
        private String[] superpowers;

        // Constructor
        public MarvelCharacter(String name, String alias) {
            this.name = name;
            this.alias = alias;
            
            // Hardcoded superpowers based on alias
            
            if (alias.equals("Iron Man")) {
                this.superpowers = new String[]{"Flight", "Repulsor blasts", "Genius-level intellect"};
            } else if (alias.equals("Captain America")) {
                this.superpowers = new String[]{"Enhanced strength", "Agility", "Shield proficiency"};
            } else if (alias.equals("Thor")) {
                this.superpowers = new String[]{"Superhuman strength", "Mjolnir wielding", "Weather manipulation"};
            } else {
                this.superpowers = new String[]{"Unknown"};
            }
        }

        // Method to display character details
        public void displayDetails() {
            logger.info("Name: " + name);
            logger.info("Alias: " + alias);
            logger.info("Superpowers:");
            for (String power : superpowers) {
                logger.info("- " + power);
            }
        }

        
    }

    public static void main(String[] args) {
        // Creating Marvel characters
        MarvelCharacter ironMan = new MarvelCharacter("Tony Stark", "Iron Man");
        MarvelCharacter captainAmerica = new MarvelCharacter("Steve Rogers", "Captain America");
        MarvelCharacter thor = new MarvelCharacter("Thor Odinson", "Thor");

        // Displaying details of Marvel characters
        logger.info("Marvel Characters:");
        ironMan.displayDetails();
        captainAmerica.displayDetails();
        thor.displayDetails();

        
    }
}

