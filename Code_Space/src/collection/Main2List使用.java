package collection;

import java.util.Iterator;
import java.util.List;

public class Main2List使用 {
	public static void main(String[] args) {
		List<String> list = List.of("apple","pear","banana");
		for(int i=0;i<list.size();i++) {
			String string =list.get(i);
			System.out.println(string);
		}
		System.out.println();
		
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String string = it.next();
			System.out.println(string);
		}
		System.out.println();

		for(String s:list) {
			System.out.println(s);
		}
	}
}
