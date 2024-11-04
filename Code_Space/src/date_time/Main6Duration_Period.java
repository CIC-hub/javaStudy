package date_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Main6Duration_Period {
	public static void main(String[] args) {
		LocalDateTime start = LocalDateTime.of(2019, 11,19,8,15,0);
		LocalDateTime end = LocalDateTime.of(2020, 1,9,19,25,30);
		Duration d = Duration.between(start, end);
		System.out.println(d);
		
//        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
//		System.out.println(p);
		
		Duration d1 = Duration.ofHours(10);
		Duration d2 = Duration.parse("P1DT2H3M");
		System.out.println(d1);
		System.out.println(d2);
	}
	
}
