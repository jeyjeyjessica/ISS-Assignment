package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
    private static final Logger logger = LogManager.getLogger(SortingExample.class);

    public static void main(String[] args) {
        // Create an ArrayList of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(10);

        // Logging the unsorted list of numbers
        logger.info("Unsorted List of Numbers: " + numbers);

        // Sorting using Comparable interface (natural ordering)
        Collections.sort(numbers);
        // Logging the sorted list of numbers
        logger.info("Sorted List of Numbers using Comparable: " + numbers);

        // Sorting using Comparator interface (reverse ordering)
        Collections.sort(numbers, Comparator.reverseOrder());
        // Logging the sorted list of numbers in reverse order
        logger.info("Sorted List of Numbers using Comparator (Reverse Order): " + numbers);
    }
}

