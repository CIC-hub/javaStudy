package collection;

import java.util.ArrayList;
import java.util.List;

public class Main1List创建 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("pear");
		list.add("apple");
		list.add(null);
		System.out.println(list.size());
		System.out.println(list);
		String fourth = list.get(3);
		System.out.println(fourth);
		
		List<Integer> list2 = List.of(1,2,3);
		System.out.println(list2);
		List<String> list3 = List.of("apple");

		list.add("apple");
		System.out.println(list);
		if(list3.containsAll(list))
			System.out.println(1);
	}

}
