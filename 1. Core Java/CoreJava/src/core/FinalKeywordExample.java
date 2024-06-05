package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FinalKeywordExample {

    private static final Logger logger = LogManager.getLogger(FinalKeywordExample.class);

    // Final variable
    private static final int MAX_VALUE = 100;

    // Final class
    public final class FinalClass {
        // Final method
        public final void finalMethod() {
            logger.info("This is a final method.");
        }
    }

    public static void main(String[] args) {
        // Attempting to reinitialize final variable (will raise an error)
        // Error: Cannot assign a value to final variable MAX_VALUE
        //logger.error("Error: Cannot reinitialize final variable.");
    	
        //MAX_VALUE = 200;

        // Attempting to extend final class (will raise an error)
        // Error: Cannot extend final class FinalClass
    	
        //class SubClass extends FinalClass {}

        // Attempting to override final method (will raise an error)
        // Error: Cannot override final method finalMethod in FinalClass
    	
        /*public class SubClass extends FinalClass {
            @Override
            public void finalMethod() {
                logger.info("This is an overridden method.");
            }
        }*/
    	
    	// Final variable usage
        logger.info("Max value: " + MAX_VALUE);

        // Final method usage
        new FinalKeywordExample().new FinalClass().finalMethod();
    }
}
