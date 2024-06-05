package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayExample {
    private static final Logger logger = LogManager.getLogger(ArrayExample.class);

    public static void main(String[] args) {
        // Declaring and initializing an array of integers
        int[] numbers = {10, 20, 30, 40, 50};

        // Printing the elements of the array
        logger.info("Array elements:");
        for (int i = 0; i < numbers.length; i++) {
            logger.info("Element at index " + i + ": " + numbers[i]);
        }

        // Calculating and printing the sum of elements
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        logger.info("Sum of array elements: " + sum);

        // Finding and printing the maximum element in the array
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        logger.info("Maximum element in the array: " + max);

        // Updating an element in the array
        numbers[2] = 35;
        logger.info("Updated array element at index 2: " + numbers[2]);
    }
}

