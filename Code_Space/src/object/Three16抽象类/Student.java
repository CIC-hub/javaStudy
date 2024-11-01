package object.Three16抽象类;

public class Student extends Person {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Student.run");
	}
	
	public static void main(String[] args) {
		Person p = new Student();
		p.run();
	}
}
