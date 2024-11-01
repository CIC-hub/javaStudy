package object.Three23StringJoiner;

import java.util.Iterator;
import java.util.StringJoiner;

public class Main1 {

	public static void main(String[] args) {
		String[] names = {"Bob","Alice","Grace"};
		StringJoiner sj =new StringJoiner(",","Hello,","!");
		for (String name : names) {
			sj.add(name);
		}
		System.out.println(sj);
		
		String s = String.join(",", names);
		System.out.println(s);
	}

}
