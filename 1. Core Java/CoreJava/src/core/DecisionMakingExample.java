package core;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DecisionMakingExample {

    private static final Logger logger = LogManager.getLogger(DecisionMakingExample.class);

    public static void main(String[] args) {
        // Predefined marks array
        int[] marks = {85, 76, 68, 57, 92};
        
        //grades list
        ArrayList<Character> grades = new ArrayList<>();

        // Calculating grades and logging the output
        logger.info("USING IF-ELSE");
        for (int i = 0; i < marks.length; i++) {
            int mark = marks[i];
            char grade;

            // Using if-else ladder to determine grade
            if (mark >= 80) {
                grade = 'O';
            } else if (mark >= 75 && mark <= 79) {
                grade = 'A';
            } else if (mark >= 70 && mark <= 74) {
                grade = 'B';
            } else if (mark >= 65 && mark <= 69) {
                grade = 'C';
            } else if (mark >= 60 && mark <= 64) {
                grade = 'D';
            } else if (mark >= 55 && mark <= 59) {
                grade = 'E';
            } else {
                grade = 'F';
            }

            // Logging the output
            logger.info("Student " + (i + 1) + " - Marks: " + mark + ", Grade: " + grade);
            grades.add(grade);
        }
        
        logger.info("USING SWITCH STATEMENT");
        
        //based on the grades displaying the comments using switch statement
        for (int i = 0; i < grades.size(); i++) {
            char grade = grades.get(i);
            String comment;

            // Using switch statement to determine comment based on grade
            switch (grade) {
                case 'O':
                    comment = "Outstanding";
                    break;
                case 'A':
                    comment = "Very Good";
                    break;
                case 'B':
                    comment = "Good";
                    break;
                case 'C':
                    comment = "Fair";
                    break;
                case 'D':
                    comment = "Okay";
                    break;
                case 'E':
                    comment = "Pass";
                    break;
                case 'F':
                    comment = "Fail";
                    break;
                default:
                    comment = "Invalid Grade";
            }

            // Logging the output
            logger.info("Student " + (i + 1) + " - Grade: " + grade + ", Comment: " + comment);
        }
        
        
        
    }
}

