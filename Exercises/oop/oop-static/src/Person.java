
public class Person {

	// TODO

	String name;
	
	public static int count;
	
	public Person(String name) {
		this.name = name;
		count++;
	}
	
	public static int getCount() {
		return count;
	}

}
