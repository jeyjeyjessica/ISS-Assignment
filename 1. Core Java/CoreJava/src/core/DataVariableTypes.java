package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Student {
    // Instance variables
    String name;
    int age;
    double gpa;
    static final String SCHOOL_NAME = "XYZ High School"; // Global variable

    // Constructor
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    // Method to display student details
    public void displayStudentDetails() {
        Logger logger = LogManager.getLogger(Student.class);
        logger.info("Student Name: " + name);
        logger.info("Age: " + age);
        logger.info("GPA: " + gpa);
        logger.info("School: " + SCHOOL_NAME);
    }

    // Method to demonstrate local variables
    public void calculateGrade() {
        Logger logger = LogManager.getLogger(Student.class);
        char grade;
        if (gpa >= 3.5) {
            grade = 'A';
        } else if (gpa >= 3.0) {
            grade = 'B';
        } else if (gpa >= 2.5) {
            grade = 'C';
        } else if (gpa >= 2.0) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        logger.info("Calculated Grade: " + grade);
    }
}

public class DataVariableTypes {
	
    //private static final Logger logger = LogManager.getLogger(DataVariableTypes.class);

    public static void main(String[] args) {
        // Local variables
        String studentName = "Jessica";
        int studentAge = 21;
        double studentGPA = 3.7;

        // Creating a Student object
        Student student = new Student(studentName, studentAge, studentGPA);

        // Displaying student details and calculating grade
        student.displayStudentDetails();
        student.calculateGrade();
    }
}

