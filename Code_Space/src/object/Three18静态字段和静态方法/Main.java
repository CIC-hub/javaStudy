package object.Three18静态字段和静态方法;

public class Main {
	public static void main(String args[]) {
		Person p1 = new Person(1);
		Person p2 = new Person(2);
		p1.number = 1;
		System.out.println(p1.number);
		
		p2.number = 2;
		System.out.println(p2.number);
		System.out.println(p1.number);
		
		Person.number = 99;
		System.out.println(Person.number);
	}
}

class Person{
	public int age;
	
	public static int number;
	
	public Person(int age){
		this.age = age;
	}
}