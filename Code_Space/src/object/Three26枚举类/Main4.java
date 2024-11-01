package object.Three26枚举类;

public class Main4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weekday4 day = Weekday4.MON;
		System.out.println(day.name());
		
		System.out.println(day.ordinal());
		System.out.println(day.dayValue);
	}

}

enum Weekday4{
	MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);
	
	public final int dayValue;
	
	private Weekday4(int dayValue) {
		this.dayValue = dayValue;
	}
}

