package core.json;

import javax.json.*;
import javax.json.stream.JsonParsingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JSONCRUDExample {
    private static final Logger logger = LogManager.getLogger(JSONCRUDExample.class);
    private static final String FILE_PATH = "data.json"; //original data in data2.json

    public static void main(String[] args) {
        JSONCRUDExample example = new JSONCRUDExample();
        List<Person> people = example.readData();

        // Create
        Person newPerson = new Person();
        newPerson.setId(3);
        newPerson.setName("Alice Johnson");
        Address newAddress = new Address();
        newAddress.setStreet("789 Pine St");
        newAddress.setCity("Mumbai");
        newAddress.setZipcode("400003");
        newPerson.setAddress(newAddress);
        example.createPerson(people, newPerson);

        // Read
        Person person = example.getPersonById(people, 1);
        logger.info("Read person: " + person);

        // Update
        person.setName("Jessica Diaz");
        example.updatePerson(people, person);

        // Delete
        example.deletePerson(people, 2);

        // Save changes to file
        example.writeData(people);
    }

    public List<Person> readData() {
        List<Person> people = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             JsonReader reader = Json.createReader(fis)) {
            JsonArray jsonArray = reader.readArray();
            for (JsonValue value : jsonArray) {
                JsonObject jsonObject = value.asJsonObject();
                Person person = parsePerson(jsonObject);
                people.add(person);
            }
        } catch (IOException | JsonParsingException e) {
            logger.error("Error reading data: ", e);
        }
        return people;
    }

    public void writeData(List<Person> people) {
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
             JsonWriter writer = Json.createWriter(fos)) {
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            for (Person person : people) {
                JsonObject personJson = createPersonJson(person);
                arrayBuilder.add(personJson);
            }
            JsonArray jsonArray = arrayBuilder.build();
            writer.writeArray(jsonArray);
        } catch (IOException e) {
            logger.error("Error writing data: ", e);
        }
    }

    public void createPerson(List<Person> people, Person newPerson) {
        people.add(newPerson);
        logger.info("Created new person: " + newPerson);
    }

    public Person getPersonById(List<Person> people, int id) {
        Optional<Person> person = people.stream().filter(p -> p.getId() == id).findFirst();
        return person.orElse(null);
    }

    public void updatePerson(List<Person> people, Person updatedPerson) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == updatedPerson.getId()) {
                people.set(i, updatedPerson);
                logger.info("Updated person: " + updatedPerson);
                return;
            }
        }
    }

    public void deletePerson(List<Person> people, int id) {
        people.removeIf(p -> p.getId() == id);
        logger.info("Deleted person with ID: " + id);
    }

    private Person parsePerson(JsonObject jsonObject) {
        Person person = new Person();
        person.setId(jsonObject.getInt("id"));
        person.setName(jsonObject.getString("name"));
        JsonObject addressJson = jsonObject.getJsonObject("address");
        Address address = new Address();
        address.setStreet(addressJson.getString("street"));
        address.setCity(addressJson.getString("city"));
        address.setZipcode(addressJson.getString("zipcode"));
        person.setAddress(address);
        return person;
    }

    private JsonObject createPersonJson(Person person) {
        JsonObjectBuilder personBuilder = Json.createObjectBuilder();
        personBuilder.add("id", person.getId());
        personBuilder.add("name", person.getName());

        Address address = person.getAddress();
        JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
        addressBuilder.add("street", address.getStreet());
        addressBuilder.add("city", address.getCity());
        addressBuilder.add("zipcode", address.getZipcode());

        personBuilder.add("address", addressBuilder);
        return personBuilder.build();
    }
}

