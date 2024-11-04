package date_time;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main8DateTimeFormatter {

	public static void main(String[] args) {
		ZonedDateTime zdt = ZonedDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm ZZZZ");
		System.out.println(formatter.format(zdt));
		DateTimeFormatter zhformatter = DateTimeFormatter.ofPattern("yyyy MMM dd EE HH:mm",Locale.CHINA);
		System.out.println(zhformatter.format(zdt));
		DateTimeFormatter usformatter = DateTimeFormatter.ofPattern("E,MMMM/dd/yyyy HH:mm", Locale.US);
		System.out.println(usformatter.format(zdt));
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println(DateTimeFormatter.ISO_DATE.format(ldt));
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(ldt));
	
	}

}
