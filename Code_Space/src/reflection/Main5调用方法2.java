package reflection;

import java.lang.reflect.Method;

public class Main5调用方法2 {

	public static void main(String[] args) throws Exception{
		String string = "Hello world";
		Method method = String.class.getMethod("substring", int.class);
		String rString = (String) method.invoke(string, 6);
		System.out.println(rString);
		
		Method method2 = Integer.class.getMethod("parseInt", String.class);
		Integer nInteger = (Integer) method2.invoke(null, "12345");
		System.out.println(nInteger);
		
		Person4 person4 = new Person4();
		Method method3 = person4.getClass().getDeclaredMethod("setName", String.class);
		method3.setAccessible(true);
		method3.invoke(person4, "Bob");
		System.out.println(person4.name);
	}

}
class Person4 {
    String name;
    private void setName(String name) {
        this.name = name;
    }
}