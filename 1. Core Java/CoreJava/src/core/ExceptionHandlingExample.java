package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionHandlingExample {
    private static final Logger logger = LogManager.getLogger(ExceptionHandlingExample.class);

    public static void main(String[] args) {
        try {
            int result = divide(10, 0); // Attempting division by zero
            logger.info("Result of division: " + result);
        } catch (ArithmeticException e) {
            logger.error("Error: " + e); // Handling division by zero exception
        }

        try {
            int[] arr = createArray(-5); // Attempting to create array with negative size
            logger.info("Array created successfully with length: " + arr.length);
        } catch (NegativeArraySizeException e) {
            logger.error("Error: " + e); // Handling negative array size exception
        }

        try {
            validateAge(15); // Attempting to validate age (custom exception)
            logger.info("Age is valid.");
        } catch (InvalidAgeException e) {
            logger.error("Error: " + e.getMessage()); // Handling custom exception
        } finally {
            logger.info("Program execution complete."); // Executing finally block
        }
    }

    // Method to handle division by zero exception
    public static int divide(int dividend, int divisor) {
    	/*
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        */
        return dividend / divisor;
    }

    // Method to handle negative array size exception
    public static int[] createArray(int size) {
    	/*
        if (size < 0) {
            throw new NegativeArraySizeException("Array size cannot be negative.");
        }
        */
        return new int[size];
    }

    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }
}

// Custom exception class for invalid age
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
