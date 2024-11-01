package date_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main2Calendar {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		int m = 1 + c.get(Calendar.MONTH);
		int d = c.get(Calendar.DAY_OF_MONTH);
		int w = c.get(Calendar.DAY_OF_WEEK);
		int hh = c.get(Calendar.HOUR_OF_DAY);
		int mm = c.get(Calendar.MINUTE);
		int ss = c.get(Calendar.SECOND);
		int ms = c.get(Calendar.MILLISECOND);	
		System.out.println(y+"-"+m+"-"+d+"-"+w+" "+hh+":"+mm+":"+ss+"."+ms);
	
		c.clear();
		c.set(Calendar.YEAR, 2019);
		c.set(Calendar.MONTH, 8);
		c.set(Calendar.DATE, 2);
		c.set(Calendar.HOUR_OF_DAY, 21);
		c.set(Calendar.MINUTE, 22);
		c.set(Calendar.SECOND, 23);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));
		
	}
}
