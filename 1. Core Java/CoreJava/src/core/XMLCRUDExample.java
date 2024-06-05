package core;

import java.io.*;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.*;
import org.dom4j.io.*;

public class XMLCRUDExample {

    private static final Logger logger = LogManager.getLogger(XMLCRUDExample.class);

    private static final String XML_FILE_PATH = "data.xml";

    public static void main(String[] args) {
        try {
            // Read XML file
            Document document = readXMLFile();

            // Display existing data
            displayXMLData(document);

            // Add new book
            addBook(document, "Lord of the Rings", "J.R.R. Tolkien", "1954");

            // Update book
            updateBook(document, "Harry Potter and the Philosopher's Stone", "Harry Potter and the Sorcerer's Stone");

            // Delete book
            deleteBook(document, "The Hobbit");

            // Write back to XML file
            writeXMLFile(document);

            // Display updated data
            displayXMLData(document);

        } catch (Exception e) {
            logger.error("Error performing XML CRUD operations: ", e);
        }
    }

    private static Document readXMLFile() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        return reader.read(new File(XML_FILE_PATH));
    }

    private static void writeXMLFile(Document document) throws IOException {
        XMLWriter writer = new XMLWriter(new FileWriter(XML_FILE_PATH));
        writer.write(document);
        writer.close();
    }

    private static void displayXMLData(Document document) {
        List<Node> bookNodes = document.selectNodes("//book");
        logger.info("Current XML Data:");
        for (Node bookNode : bookNodes) {
            Element bookElement = (Element) bookNode;
            logger.info("Name: " + bookElement.elementText("name") + ", Author: " + bookElement.elementText("author") + ", Year: " + bookElement.elementText("year"));
        }
    }

    private static void addBook(Document document, String name, String author, String year) {
        Element booksElement = document.getRootElement();
        Element newBookElement = booksElement.addElement("book");
        newBookElement.addElement("name").setText(name);
        newBookElement.addElement("author").setText(author);
        newBookElement.addElement("year").setText(year);
        logger.info("New book added successfully: " + name);
    }

    private static void updateBook(Document document, String oldName, String newName) {
        Element booksElement = document.getRootElement();
        Element bookElement = (Element) booksElement.selectSingleNode("//book[name=\"" + oldName + "\"]");
        if (bookElement != null) {
            bookElement.element("name").setText(newName);
            logger.info("Book updated successfully: " + oldName + " renamed to " + newName);
        } else {
            logger.warn("Book not found: " + oldName);
        }
    }


    private static void deleteBook(Document document, String name) {
        Element booksElement = document.getRootElement();
        Element bookElement = (Element) booksElement.selectSingleNode("//book[name='" + name + "']");
        if (bookElement != null) {
            bookElement.getParent().remove(bookElement);
            logger.info("Book deleted successfully: " + name);
        } else {
            logger.warn("Book not found: " + name);
        }
    }
}

