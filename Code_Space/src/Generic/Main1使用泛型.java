package Generic;

import java.util.Arrays;

public class Main1使用泛型 {

	public static void main(String[] args) {
		String[] strings = new String[] {
				"orange","Apple","Pear"
		};
		Arrays.sort(strings);
		System.out.println(Arrays.toString(strings));
		
		Person[] persons = new Person[] {
				new Person("Bob", 1),
				new Person("aob", 2),
				new Person("Cob", 3),
		};
		Arrays.sort(persons);
        System.out.println(Arrays.toString(persons));

	}

}

class Person implements Comparable<Person>{
	String nameString;
	int score;
	Person(String nameString,int score){
		this.nameString = nameString;
		this.score = score;
	}
	public int compareTo(Person otherPerson) {
//		return this.nameString.compareTo(otherPerson.nameString);
		return this.score > otherPerson.score ?1:-1;
	}
	
	public String toString() {
		return this.nameString + ',' +this.score;
	}
}