package core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileReadWriteExample {

    private static final Logger logger = LogManager.getLogger(FileReadWriteExample.class);

    private static final String FILE_PATH = "data.txt";

    public static void main(String[] args) {
        try {
            // Read existing data from file
            List<String> existingData = readFromFile();
            logger.info("Existing data read from file: " + existingData);

            // Create data
            List<String> newData = new ArrayList<>();
            newData.add("Jessica");
            newData.add("Evan");
            newData.add("Bobby");

            // Write new data to file
            writeToFile(newData);

            // Read updated data from file
            List<String> updatedData = readFromFile();
            logger.info("Updated data read from file: " + updatedData);

            // Update data
            updateFile(updatedData, "Evan", "David");

            // Read updated data from file
            List<String> secondUpdatedData = readFromFile();
            logger.info("Second updated data read from file: " + secondUpdatedData);

            // Delete data
            deleteFromFile(secondUpdatedData, "Bobby");

            // Read data after deletion
            List<String> finalData = readFromFile();
            logger.info("Final data after deletion: " + finalData);
        } catch (IOException e) {
            logger.error("Error performing file read/write operations: ", e);
        }
    }

    private static List<String> readFromFile() throws IOException {
        List<String> content = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        }
        return content;
    }

    private static void writeToFile(List<String> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            for (String item : data) {
                writer.write(item + "\n");
            }
            logger.info("Data written to file successfully.");
        }
    }

    private static void updateFile(List<String> data, String oldValue, String newValue) throws IOException {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(oldValue)) {
                data.set(i, newValue);
            }
        }
        rewriteFile(data); // Update file with modified data
        logger.info("File updated successfully.");
    }

    private static void deleteFromFile(List<String> data, String valueToDelete) throws IOException {
        data.removeIf(item -> item.equals(valueToDelete));
        rewriteFile(data); // Update file after deletion
        logger.info("Value '{}' deleted from file.", valueToDelete);
    }

    private static void rewriteFile(List<String> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String item : data) {
                writer.write(item + "\n");
            }
        }
    }
}
