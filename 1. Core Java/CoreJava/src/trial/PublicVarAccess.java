package trial;

import core.ModifierExample;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PublicVarAccess {
	private static final Logger logger = LogManager.getLogger(PublicVarAccess.class.getName());

	public static void main(String[] args) {

		
		ModifierExample object1 = new ModifierExample();
		logger.info("Accessing public variable : ");
		logger.info(object1.publicVariable);
		
		logger.info("Accessing public method");
		object1.publicMethod();
		

	}

}
