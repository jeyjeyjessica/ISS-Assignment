package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    private static final Logger logger = LogManager.getLogger(SetExample.class);

    public static void main(String[] args) {
        // Create a custom object Firefighter
        class Firefighter {
            private int badgeNumber;
            private int stationNumber;
            private String name;

            public Firefighter(int badgeNumber, int stationNumber, String name) {
                this.badgeNumber = badgeNumber;
                this.stationNumber = stationNumber;
                this.name = name;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Firefighter that = (Firefighter) o;
                return badgeNumber == that.badgeNumber && stationNumber == that.stationNumber && name.equals(that.name);
            }

            @Override
            public int hashCode() {
                int result = badgeNumber;
                result = 31 * result + stationNumber;
                result = 31 * result + name.hashCode();
                return result;
            }

            @Override
            public String toString() {
                return "Firefighter{" +
                        "badgeNumber=" + badgeNumber +
                        ", stationNumber=" + stationNumber +
                        ", name='" + name + '\'' +
                        '}';
            }
        }

        // Create a HashSet of Firefighter objects
        Set<Firefighter> firefighters = new HashSet<>();

        // Adding Firefighter objects to the set
        firefighters.add(new Firefighter(101, 5, "Jessica"));
        firefighters.add(new Firefighter(102, 3, "Hen"));
        firefighters.add(new Firefighter(103, 7, "Evan"));
        firefighters.add(new Firefighter(104, 2, "Eddie"));
        firefighters.add(new Firefighter(105, 6, "Bobby"));
        
        //Checking size
        logger.info("Size of the set : " + firefighters.size());

        // Adding a duplicate firefighter
        firefighters.add(new Firefighter(101, 5, "Jessica"));

        // Logging the elements of the firefighters set
        logger.info("Size of firefighters set after adding duplicate: " + firefighters.size());
        
     // Check if the set contains a specific firefighter
        Firefighter firefighterToCheck = new Firefighter(101, 5, "Jessica");
        logger.info("Does the set contain firefighter " + firefighterToCheck + "? " + firefighters.contains(firefighterToCheck));

        // Removing a firefighter from the set
        Firefighter firefighterToRemove = new Firefighter(103, 7, "Evan");
        boolean removed = firefighters.remove(firefighterToRemove);
        logger.info("Is firefighter " + firefighterToRemove + " removed from the set? " + removed);
        logger.info("Elements of firefighters set after removal: " + firefighters);

        // Clearing the set
        firefighters.clear();
        logger.info("Firefighters set cleared. Size: " + firefighters.size());
        logger.info("Is the set empty? " + firefighters.isEmpty());
    }
}
