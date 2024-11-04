package date_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main7ZonedDateTime {

	public static void main(String[] args) {
		ZonedDateTime zbj = ZonedDateTime.now();
		ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println(zbj);
		System.out.println(zny);

		LocalDateTime ldt2 = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
		ZonedDateTime zbj2 = ldt2.atZone(ZoneId.systemDefault());
		ZonedDateTime zny2 = ldt2.atZone(ZoneId.of("America/New_York"));
		System.out.println(zbj2);
		System.out.println(zny2);
		
		ZonedDateTime zbj3 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
		ZonedDateTime zny3 = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
		System.out.println(zbj3);
		System.out.println(zny3);
	}

}
