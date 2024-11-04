package date_time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main9Instant {

	public static void main(String[] args) {
		Instant now = Instant.now();
		System.out.println(now.getEpochSecond());
		System.out.println(now.toEpochMilli());
		
		ZonedDateTime zdt = now.atZone(ZoneId.systemDefault());
		System.out.println(zdt);
	}

}
