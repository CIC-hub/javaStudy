package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main8使用Set {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		System.out.println(set.add("abc"));
		System.out.println(set.add("xyz"));
		System.out.println(set.add("xyz"));
		System.out.println(set.contains("abc"));
		System.out.println(set.contains("XYZ"));
		System.out.println(set.remove("Hello"));
		System.out.println(set.size());
		System.out.println();
		
		Set<String> set2 = new HashSet<String>();
		set2.add("apple");
		set2.add("banana");
		set2.add("pear");
		set2.add("orange");
		for(String s:set2) {
			System.out.println(s);
		}System.out.println();
		
		Set<String> set3 = new TreeSet<>();
		set3.add("apple");
		set3.add("banana");
		set3.add("pear");
		set3.add("orange");
		for(String s:set3) {
			System.out.println(s);
		}
	}

}

