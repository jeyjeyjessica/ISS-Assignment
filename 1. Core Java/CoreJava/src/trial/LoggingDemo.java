package trial;

import org.apache.logging.log4j.*;



public class LoggingDemo {
	
	
	private static Logger demoLogger = LogManager.getLogger(LoggingDemo.class.getName());
	
	public static void main(String args[]) {
		
		//default 
		// If no configuration file could be located the DefaultConfiguration will be used. 
		//This will cause logging output to go to the console.
		
		demoLogger.info("Clicked button"); //not logged because of default levels
		demoLogger.error("DB Connection failed"); //gives timestamp and all the details alongwith package and class name
		demoLogger.debug("Debug message");
		demoLogger.fatal("Fatal error");
		
	}

}
