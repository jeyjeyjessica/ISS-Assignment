package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MethodOverridingExample {
   

    public static void main(String[] args) {
        // Creating instances of each class
        Wizard harry = new Wizard("Harry Potter");
        harry.castSpell();

        DarkWizard voldemort = new DarkWizard("Voldemort");
        voldemort.castSpell();
    }
}

// Base class - Wizard
class Wizard {
	 private static final Logger logger = LogManager.getLogger(Wizard.class);
    protected String name;

    Wizard(String name) {
        this.name = name;
    }

    public void castSpell() {
        logger.info(name + " casts a generic spell.");
    }
}

// Subclass - DarkWizard
class DarkWizard extends Wizard {
	 private static final Logger logger = LogManager.getLogger(DarkWizard.class);
    DarkWizard(String name) {
        super(name);
    }

    @Override
    public void castSpell() {
        logger.info(name + " casts a dark spell.");
    }
}

