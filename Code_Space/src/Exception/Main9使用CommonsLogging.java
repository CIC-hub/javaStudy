package Exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main9使用CommonsLogging {
	
	static final Log log2 = LogFactory.getLog(Main9使用CommonsLogging.class); 
	protected final Log log3 = LogFactory.getLog(getClass());
	
	public static void main(String[] args) {
		Log log = LogFactory.getLog(Main9使用CommonsLogging.class);
		log.info("start");
		log.warn("end");
		
		foo();
		
	}
	
	static void foo() {
		log2.info("foo");
	}
	
	void foo2() {
		log3.info("foo2");
	}

}
//javac -cp commons-logging-1.3.4.jar Main9使用CommonsLogging.java
//java -cp .;commons-logging-1.3.4.jar Main9使用CommonsLogging.java