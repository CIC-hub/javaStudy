package collection;

import java.util.*;

public class Main10使用Collections {

	public static void main(String[] args) {
		List<String> emptyList = Collections.emptyList();
		System.out.println(emptyList);
		List<String> singleList = Collections.singletonList("banana");
		System.out.println(singleList);
		
		List<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("pear");
		list.add("orange");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		List<Integer>list2 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list2.add(i);
		}
		System.out.println(list2);
		Collections.shuffle(list2);
		System.out.println(list2);
		System.out.println();
		
		List<String>mutableList = new ArrayList<String>();
		mutableList.add("apple");
		mutableList.add("pear");
		List<String>immutableList = Collections.unmodifiableList(mutableList);
		System.out.println(immutableList);
//		immutableList.add("orange");
		mutableList.add("orange");
		System.out.println(mutableList);
		mutableList = null;
		System.out.println(immutableList);
		
		
	}

}
