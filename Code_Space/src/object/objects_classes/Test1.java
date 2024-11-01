package object.objects_classes;

public class Test1 {
	public static void main(String[] args){
		Person person = new Person();
		person.name = "David";
		
		person.showName();
		System.out.println("age is "+person.getAge());
		person.age = 10;
		System.out.println("age is "+person.getAge());
		
		Animal ani = new Animal();
		ani.eat("food");
		ani.move("fly");
		
		new Person().showName();
		
	}
}
