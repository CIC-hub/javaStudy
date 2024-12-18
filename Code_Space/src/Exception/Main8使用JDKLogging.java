package Exception;

import java.util.logging.Logger;

public class Main8使用JDKLogging {

	public static void main(String[] args) {
		Logger logger = Logger.getGlobal();
		logger.info("start");
		logger.warning("memory run out");
		logger.fine("ignored");
		logger.severe("terminated");
	}

}
