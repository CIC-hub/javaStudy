package date_time;
import java.time.*;

public class Main4LocalDateTime {

	public static void main(String[] args) {
		LocalDate d = LocalDate.now();
		LocalTime t = LocalTime.now();
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(d);
		System.out.println(t);
		System.out.println(dt);

		d = dt.toLocalDate();
		t = dt.toLocalTime();
		System.out.println(d);
		System.out.println(t);
		
		LocalDate d2 = LocalDate.of(2019, 11, 30);
		System.out.println(d2);
		LocalTime t2 = LocalTime.of(15, 16, 17);
		System.out.println(t2);
		LocalDateTime dt2 = LocalDateTime.of(2019, 11, 30, 15, 16, 17);
		System.out.println(dt2);
		LocalDateTime dt3 = LocalDateTime.of(d2, t2);
		System.out.println(dt3);
		
		LocalDateTime dt4 =  LocalDateTime.parse("2019-11-19T15:16:17");
		LocalDate d3 = LocalDate.parse("2019-11-19");
		LocalTime t3 = LocalTime.parse("15:16:17");
		System.out.println(dt4);
		System.out.println(d3);
		System.out.println(t3);
		
		
	}

}
