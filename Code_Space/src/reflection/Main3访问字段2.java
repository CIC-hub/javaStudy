package reflection;

import java.lang.reflect.Field;

public class Main3访问字段2 {

    public static void main(String[] args) throws Exception {
    	 Object p = new Person2("Xiao Ming");
         Class c = p.getClass();
         Field f = c.getDeclaredField("name");
         f.setAccessible(true);
         Object value = f.get(p);
         System.out.println(value); // "Xiao Ming"
     }
}

class Person2 {
	private String name;

    public Person2(String name) {
        this.name = name;
    }
}