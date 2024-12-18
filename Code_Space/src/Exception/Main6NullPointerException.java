package Exception;

public class Main6NullPointerException {

	public static void main(String[] args) {
		Person person = new Person();
		System.out.println(person.address.cityString.toLowerCase());
	}

}
class Person{
	String[] nameString = new String[2];
	Address address = new Address();
}

class Address{
	String cityString;
	String streetString;
	String zipcodeString;
}