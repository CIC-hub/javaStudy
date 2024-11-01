package object.Three26枚举类;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weekday2 day = Weekday2.SUN;
		System.out.println(day);
		
		if (day == Weekday2.SUN || day == Weekday2.SAT) {
			System.out.println("home");
		}else {
			System.out.println("work");
		}
	}

}
enum Weekday2{
	SUN, MON, TUE, WED, THU, FRI, SAT;
}

