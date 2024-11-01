package object.Three22StringBuilder;

import java.util.Iterator;

public class Main1 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(1024);
		for (int i = 0; i < 10; i++) {
			sb.append(',');
			sb.append(i);
		}
		String s = sb.toString();
		System.out.println(s);
		
		StringBuilder sb2 = new StringBuilder(1024);
		sb2.append("Mr")
		.append("Bob")
		.append("!")
		.insert(0,"Hello,");
		System.out.println(sb2);
	}

}
