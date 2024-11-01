package object.Three26枚举类;

public class Main6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weekday6 day = Weekday6.SUN;
//		int day = 1; //Error
		switch (day) {
		case SUN:
			System.out.println(day);
			break;
		case MON:
			System.out.println(day);
			break;
		case TUE:
			System.out.println(day);
			break;
		case WED:
			System.out.println(day);
			break;
		case THU:
			System.out.println(day);
			break;
		case FRI:
			System.out.println(day);
			break;
		case SAT:
			System.out.println(day);
			break;
		default:
			System.out.println("default");
			break;
		}
		
	}

}

enum Weekday6{
	SUN, MON, TUE, WED, THU, FRI, SAT;
}
