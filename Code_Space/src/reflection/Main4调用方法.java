package reflection;

public class Main4调用方法 {

	public static void main(String[] args) throws Exception{
		Class stdClass = Student3.class;
		System.out.println(stdClass.getMethod("getScore", String.class));
		System.out.println(stdClass.getMethod("getName"));
		System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
	}

}
class Student3 extends Person3 {
    public int getScore(String type) {
        return 99;
    }
    private int getGrade(int year) {
        return 1;
    }
}

class Person3 {
    public String getName() {
        return "Person";
    }
}