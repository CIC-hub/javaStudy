package reflection;

import java.lang.reflect.Method;

public class Main6调用方法3 {

	public static void main(String[] args) throws Exception{
		Method hMethod = Person5.class.getMethod("hello");
		hMethod.invoke(new Student5());
	}

}
class Person5 {
    public void hello() {
        System.out.println("Person:hello");
    }
}

class Student5 extends Person5 {
    public void hello() {
        System.out.println("Student:hello");
    }
}