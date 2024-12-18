package Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main11使用SLF4J和Logback {
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		int score = 1;
		Person p = new Person("li hua");
		logger.info("Set score {} for Person {} ok.", score, p.namString);
	}
	class Person{
		String namString;
		Person(String nameString) {
			this.namString = nameString;
		}
		
	}
}
