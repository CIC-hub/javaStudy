package date_time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Locale;

public class Main10 {

	public static void main(String[] args) {
		// Date -> Instant:
		 Instant ins1 = new Date().toInstant();
		 System.out.println(ins1);
		// Calendar -> Instant -> ZonedDateTime:		 
		 Calendar calendar = Calendar.getInstance();
		 Instant ins2 = calendar.toInstant();
		 ZonedDateTime zdt = ins2.atZone(calendar.getTimeZone().toZoneId());
		 System.out.println(calendar);
		 System.out.println(ins2);
		 System.out.println(zdt);
		 System.out.println();
		 
		// ZonedDateTime -> long:
		 ZonedDateTime zdt2 = ZonedDateTime.now();
		 long ts = zdt2.toEpochSecond()*1000;
		 System.out.println(zdt2);
		 System.out.println(ts);
		// long -> Date:
		 Date date = new Date(ts);
		 System.out.println(date);
		// long -> Calendar:
		 Calendar calendar2 = Calendar.getInstance();
		 System.out.println(calendar2);
		 calendar2.clear();
		 System.out.println(calendar2);
		 calendar2.setTimeZone(TimeZone.getTimeZone(zdt2.getZone().getId()));
		 System.out.println(calendar2);
		 calendar2.setTimeInMillis(zdt.toEpochSecond()*1000);
		 System.out.println(calendar2);
		 System.out.println();
		 
	 	long ts2 = 1574208900000L;
	 	System.out.println(timestampToString(ts2, Locale.CHINA, "Asia/Shanghai"));
	 	System.out.println(timestampToString(ts2, Locale.US, "America/New_York"));
	}

    static String timestampToString(long epochMilli, Locale lo, String zoneId) {
    	Instant ins = Instant.ofEpochMilli(epochMilli);
    	DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM,FormatStyle.SHORT);
    	return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
    }
}
