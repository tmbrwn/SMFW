package oneyre.smfw;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class SmfwLogger {

	private Logger logger = null;
	
	public void init(Logger logger) {
		this.logger = logger;
	}
	
	public void info(String message) {
		if(logger != null)	
			logger.log(Level.INFO, message);
	}
	
	public void debug(String message) {
		if(logger != null)
			logger.debug(message);
	}
	
	public void error(String message) {
		if(logger != null)
			logger.error(message);
	}
	
}
