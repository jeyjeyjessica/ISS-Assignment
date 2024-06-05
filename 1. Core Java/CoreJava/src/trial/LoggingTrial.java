package trial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingTrial {

	private static Logger demoLogger = LogManager.getLogger(LoggingDemo.class.getName());
	public static void main(String[] args) {
		demoLogger.info("Clicked button"); //not logged because of default levels
		demoLogger.error("DB Connection failed"); //gives timestamp and all the details alongwith package and class name
		demoLogger.debug("Debug message");
		demoLogger.fatal("Fatal error");
		

	}

}
