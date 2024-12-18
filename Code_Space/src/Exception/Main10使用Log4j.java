package Exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main10使用Log4j {

	public static void main(String[] args) {
		Log log = LogFactory.getLog(Main10使用Log4j.class);
		log.fatal("fatal");
		log.error("error");
		log.warn("warn");	
		log.info("info");
		log.debug("debug");
		log.trace("trace");
	}
}
//javac -cp commons-logging-1.3.4.jar Main10使用Log4j.java
//java -cp .;commons-logging-1.3.4.jar;log4j-api-2.24.2.jar;log4j-core-2.24.2.jar;log4j-jcl-2.24.2.jar;log4j2.xml Main10使用Log4j.java