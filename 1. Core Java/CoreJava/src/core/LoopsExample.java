package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoopsExample {

    private static final Logger logger = LogManager.getLogger(LoopsExample.class);
    private static final int TOTAL_MARKS = 600;

    public static void main(String[] args) {
        // Array of student marks
        int[] studentMarks = {480, 560, 300, 450, 540};
        
        // Using a for loop to calculate and log the percentage of each student
        logger.info("Calculating percentages using for loop:");
        for (int i = 0; i < studentMarks.length; i++) {
            double percentage = ((double) studentMarks[i] / TOTAL_MARKS) * 100;
            logger.info("Student " + (i + 1) + " Percentage: " + percentage + "%");
        }
        
        // Using a while loop to calculate and log the percentage of each student
        logger.info("Calculating percentages using while loop:");
        int i = 0;
        while (i < studentMarks.length) {
            double percentage = ((double) studentMarks[i] / TOTAL_MARKS) * 100;
            logger.info("Student " + (i + 1) + " Percentage: " + percentage + "%");
            i++;
        }
    }
}
