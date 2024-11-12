package collection;

import java.util.List;
import java.util.Objects;

public class Main4equals方法 {

	public static void main(String[] args) {
		List<String> list = List.of("A","B","C");
		System.out.println(list.contains("C"));
		System.out.println(list.contains("X"));
		System.out.println(list.indexOf("C"));
		System.out.println(list.indexOf("X"));
		System.out.println();
		
		System.out.println(list.contains(new String("C")));
		System.out.println(list.indexOf(new String("C")));
		System.out.println();
		
		List<Person> list2 = List.of(
				new Person("xiao ming",11),
				new Person("xiao hong",12),
				new Person("Bob",13)
				);
		System.out.println(list2.contains(new Person("Bob",13)));
	}

}

class Person{
	String name;
	int age;
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Person p) {
			return Objects.equals(this.name, p.name) && this.age==p.age;
		}
		return false;
	}
}