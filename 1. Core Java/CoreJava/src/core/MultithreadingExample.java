package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadingExample {
    private static final Logger logger = LogManager.getLogger(MultithreadingExample.class);

    // Shared volatile variable
    private volatile int sharedCounter = 0;

    public static void main(String[] args) {
        MultithreadingExample example = new MultithreadingExample();

        // Create a thread pool with a fixed number of threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit tasks to the executor
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                example.performTask();
                example.incrementSharedCounter();
            });
        }

        // Shutdown the executor
        executor.shutdown();

        try {
            // Wait for all tasks to complete
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.error("Thread pool interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        // Logging the final value of the shared counter
        logger.info("Final value of shared counter: " + example.sharedCounter);
    }

    // Task to be performed by each thread
    private void performTask() {
        Random random = new Random();
        int randomNumber = random.nextInt(100); // Local variable, thread-safe
        String message = "Thread " + Thread.currentThread().getName() + " generated number: " + randomNumber;
        logger.info(message);
    }

    // Increment the shared counter
    private synchronized void incrementSharedCounter() {
        sharedCounter++;
        logger.info("Thread " + Thread.currentThread().getName() + " incremented shared counter to: " + sharedCounter);
    }
}

