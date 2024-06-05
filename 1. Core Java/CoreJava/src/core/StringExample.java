package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringExample {
    private static final Logger logger = LogManager.getLogger(StringExample.class);

    public static void main(String[] args) {
        String str = "My name is Jessica";

        // Length of the string
        int length = str.length();
        logger.info("Length of the string: " + length);

        // Check if string contains a substring
        boolean containsName = str.contains("name");
        logger.info("Does the string contain 'name'?: " + containsName);

        // Replace a substring
        String replacedStr = str.replace("Jessica", "John");
        logger.info("Replaced string: " + replacedStr);

        // Split the string
        String[] parts = str.split(" ");
        logger.info("Split string:");
        for (String part : parts) {
            logger.info(part);
        }
        
        // Get substring
        String substring = str.substring(3, 8);
        logger.info("Substring: " + substring);
        
        // Strings are immutable, hence using StringBuffer and StringBuilder
        
        // Using StringBuffer
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(", and I love programming.");
        logger.info("Using StringBuffer: " + stringBuffer);

        // Using StringBuilder with reverse()
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        logger.info("Using StringBuilder: " + stringBuilder);
        
    }
}

