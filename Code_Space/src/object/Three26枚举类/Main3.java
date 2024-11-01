package object.Three26枚举类;

public class Main3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weekday3 day = Weekday3.SUN;
		System.out.println(day.name());
		
		System.out.println(day.ordinal());
		Weekday32 day32 = Weekday32.SUN;
		System.out.println(day32.ordinal());
	}

}

enum Weekday3{
	SUN, MON, TUE, WED, THU, FRI, SAT;
}

enum Weekday32{
    MON, TUE, WED, THU, FRI, SAT, SUN;
}