package object.objects_classes;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person2 p2 = new Person2();
		
		String[] s2 = new String[] {"a","b","c"};
		p2.printInfo(s2);
		new Person2().printInfo(s2);
		
		String str = "afg";
		p2.printInfo2(str);
		new Person2().printInfo2("abc");
		

	}

}
