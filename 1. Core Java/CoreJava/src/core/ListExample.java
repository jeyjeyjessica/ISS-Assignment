package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    private static final Logger logger = LogManager.getLogger(ListExample.class);

    public static void main(String[] args) {
        // Create a custom ArrayList of numbers
        List<Integer> numbers = new ArrayList<>();
        
        // Adding elements to the list
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        
        // Logging the elements of the list
        logger.info("Elements of numbers list: " + numbers);
        
        // Getting the size of the list
        logger.info("Size of numbers list: " + numbers.size());
        
        // Checking if the list contains a specific element
        logger.info("Does numbers list contain 30? " + numbers.contains(30));
        
        // Getting an element by index
        logger.info("Element at index 2: " + numbers.get(2));
        
        // Removing an element from the list
        numbers.remove(2);
        logger.info("After removing element at index 2: " + numbers);
        
        // Creating a custom object Student
        class Student {
            private int id;
            private String name;

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            @Override
            public String toString() {
                return "Student{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
            }
        }
        
        // Create a custom ArrayList of Student objects
        List<Student> students = new ArrayList<>();
        
        // Adding Student objects to the list
        students.add(new Student(1, "Jessica"));
        students.add(new Student(2, "Evan"));
        students.add(new Student(3, "Eddie"));
        
        // Logging the elements of the students list
        logger.info("Elements of students list: " + students);
    }
}

