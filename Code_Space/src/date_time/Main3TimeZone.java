package date_time;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Main3TimeZone {

	public static void main(String[] args) {
		TimeZone tzDefault = TimeZone.getDefault();
		TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+9:00");
		TimeZone tzNY = TimeZone.getTimeZone("America/New_York");
		System.out.println(tzDefault.getID());
		System.out.println(tzGMT9.getID());
		System.out.println(tzNY.getID());
		
		Calendar c = Calendar.getInstance();
		c.clear();
		c.setTimeZone(TimeZone.getTimeZone("Asia/Shaanghai"));
		c.set(2019,10,20,8,15,0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(c.getTime()));
		sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		System.out.println(sdf.format(c.getTime()));
		
		Calendar c2 = Calendar.getInstance();
		c2.clear();
		c2.set(2019,10,20,8,15,0);
		c2.add(Calendar.DAY_OF_MONTH, 5);
		c2.add(Calendar.HOUR_OF_DAY, -2);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf2.format(c2.getTime()));
	}

}
