package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main2访问字段 {
	public static void main(String[] args) throws NoSuchFieldException {
		Class stdClass = Student.class;
        System.out.println(stdClass.getField("score"));
        System.out.println(stdClass.getField("name"));
        System.out.println(stdClass.getDeclaredField("grade"));

        Field f = String.class.getDeclaredField("value");
        System.out.println(f.getName());; // "value"
        System.out.println(f.getType());; // class [B 表示byte[]类型
        int m = f.getModifiers();
        System.out.println(Modifier.isFinal(m));; // true
        System.out.println(Modifier.isPublic(m));; // false
        System.out.println(Modifier.isProtected(m));; // false
        System.out.println(Modifier.isPrivate(m));; // true
        System.out.println(Modifier.isStatic(m));; // false
        
	}
}
class Student extends Person {
    public int score;
    private int grade;
}

class Person {
    public String name;
}