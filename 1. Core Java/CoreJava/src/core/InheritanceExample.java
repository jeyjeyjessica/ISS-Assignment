package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Base class - Employee
class Employee {
	private static final Logger logger = LogManager.getLogger(Employee.class);
 protected int employeeID;
 protected String name;

 Employee(int employeeID, String name) {
     this.employeeID = employeeID;
     this.name = name;
 }

 public void displayEmployeeDetails() {
     logger.info("Employee ID: " + employeeID);
     logger.info("Name: " + name);
 }
}

//Single level inheritance - Subclass Teacher
class Teacher extends Employee {
	private static final Logger logger = LogManager.getLogger(Teacher.class);
 private String subject;

 Teacher(int employeeID, String name, String subject) {
     super(employeeID, name);
     this.subject = subject;
 }

 public void displayTeacherDetails() {
     logger.info("Subject: " + subject);
 }
}

//Multiple inheritance - Subclass SoftwareDeveloper
class SoftwareDeveloper extends Employee {
	private static final Logger logger = LogManager.getLogger(SoftwareDeveloper.class);
 private String programmingLanguage;

 SoftwareDeveloper(int employeeID, String name, String programmingLanguage) {
     super(employeeID, name);
     this.programmingLanguage = programmingLanguage;
 }

 public void displayDeveloperDetails() {
     logger.info("Programming Language: " + programmingLanguage);
 }
}

//Multilevel inheritance - Subclass EnglishSubject
class EnglishSubject extends Teacher {
	private static final Logger logger = LogManager.getLogger(EnglishSubject.class);
 private String specialization;

 EnglishSubject(int employeeID, String name, String subject, String specialization) {
     super(employeeID, name, subject);
     this.specialization = specialization;
 }

 public void displayEnglishSubjectDetails() {
     logger.info("Specialization: " + specialization);
 }
}


public class InheritanceExample {
    //private static final Logger logger = LogManager.getLogger(InheritanceExample.class);

    public static void main(String[] args) {
        // Single level inheritance
        Teacher teacher = new Teacher(1, "Alice", "Math");
        teacher.displayEmployeeDetails();
        teacher.displayTeacherDetails();

        // Multiple inheritance
        SoftwareDeveloper developer = new SoftwareDeveloper(2, "Bob", "Java");
        developer.displayEmployeeDetails();
        developer.displayDeveloperDetails();

        // Multilevel inheritance
        EnglishSubject englishTeacher = new EnglishSubject(3, "Carol", "English", "British Literature");
        englishTeacher.displayEmployeeDetails();
        englishTeacher.displayTeacherDetails();
        englishTeacher.displayEnglishSubjectDetails();
    }
}

