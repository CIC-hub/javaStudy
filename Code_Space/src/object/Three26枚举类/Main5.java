package object.Three26枚举类;

public class Main5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weekday5 day = Weekday5.MON;
		System.out.println(day.dayValue);
		System.out.println(day.chinese);
		
		System.out.println(day.name());
		System.out.println(day.toString());//不重写和name一样
		
	}

}

enum Weekday5{
	MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");	
	public final int dayValue;
	public final String chinese;
	
	private Weekday5(int dayValue,String chinese) {
		this.dayValue = dayValue;
		this.chinese = chinese;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.chinese;
	}
}
