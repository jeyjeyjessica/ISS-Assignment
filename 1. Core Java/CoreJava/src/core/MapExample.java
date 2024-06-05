package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    private static final Logger logger = LogManager.getLogger(MapExample.class);

    public static void main(String[] args) {
        // Define Employee class
        class Employee {
            private int id;
            private int rating;

            public Employee(int id, int rating) {
                this.id = id;
                this.rating = rating;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "id=" + id +
                        ", rating=" + rating +
                        '}';
            }
        }

        // Create a Map of Employee objects
        Map<Integer, Employee> employees = new HashMap<>();
        employees.put(101, new Employee(101, 4));
        employees.put(102, new Employee(102, 3));
        employees.put(103, new Employee(103, 5));
        employees.put(104, new Employee(104, 2));
        employees.put(105, new Employee(105, 4));

        // Logging the map of employees
        logger.info("Map of Employees: " + employees);

        // Get an employee by id
        int idToGet = 103;
        if (employees.containsKey(idToGet)) {
            logger.info("Employee with ID " + idToGet + ": " + employees.get(idToGet));
        } else {
            logger.info("Employee with ID " + idToGet + " not found");
        }

        // Check if an employee exists by id
        int idToCheck = 106;
        logger.info("Does employee with ID " + idToCheck + " exist? " + employees.containsKey(idToCheck));

        // Remove an employee by id
        int idToRemove = 104;
        if (employees.containsKey(idToRemove)) {
            logger.info("Removing employee with ID " + idToRemove + ": " + employees.remove(idToRemove));
        } else {
            logger.info("Employee with ID " + idToRemove + " not found for removal");
        }

        // Logging the updated map of employees
        logger.info("Updated Map of Employees after removal: " + employees);

        // Get the size of the map
        logger.info("Size of the Map of Employees: " + employees.size());

        // Clear the map
        employees.clear();
        logger.info("Map of Employees cleared. Size: " + employees.size());
    }
}

