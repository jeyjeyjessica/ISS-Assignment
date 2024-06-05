package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModifierExample {

    private static final Logger logger = LogManager.getLogger(ModifierExample.class);

    // Private variable accessible only within this class
    private int privateVariable = 10;

    // Default (package-private) variable accessible within the same package
    int defaultVariable = 20;

    // Protected variable accessible within the same package and by subclasses
    protected int protectedVariable = 30;

    // Public variable accessible from anywhere
    public int publicVariable = 40;

    // Private method accessible only within this class
    private void privateMethod() {
        logger.info("Private method called.");
    }

    // Default (package-private) method accessible within the same package
    void defaultMethod() {
        logger.info("Default method called.");
    }

    // Protected method accessible within the same package and by subclasses
    protected void protectedMethod() {
        logger.info("Protected method called.");
    }

    // Public method accessible from anywhere
    public void publicMethod() {
        logger.info("Public method called.");
    }

    public static void main(String[] args) {
        ModifierExample example = new ModifierExample();

        // Accessing variables and methods within the same class
        example.privateMethod();
        example.defaultMethod();
        example.protectedMethod();
        example.publicMethod();

        logger.info("Private variable: " + example.privateVariable);
        logger.info("Default variable: " + example.defaultVariable);
        logger.info("Protected variable: " + example.protectedVariable);
        logger.info("Public variable: " + example.publicVariable);
    }
}

