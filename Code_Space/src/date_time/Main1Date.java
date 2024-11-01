package date_time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main1Date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getYear()+1900);
		System.out.println(date.getMonth()+1);
		System.out.println(date.getDate());
		System.out.println(date.toString());
		System.out.println(date.toGMTString());
		System.out.println(date.toLocaleString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
		
		sdf = new SimpleDateFormat("E MMM dd, yyyy");
		System.out.println(sdf.format(date));
	}
}
