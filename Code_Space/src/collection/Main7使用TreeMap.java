package collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main7使用TreeMap {

	public static void main(String[] args) {
		Map<String, Integer> map = new TreeMap<>();
		map.put("orange", 1);
		map.put("apple", 2);
		map.put("pear", 3);
		for(String key:map.keySet()) {
			System.out.println(key);
		}System.out.println();
		
		Map<Person2, Integer> map2 = new TreeMap<>(new Comparator<Person2>() {
			public int compare(Person2 p1,Person2 p2) {
				return p1.name.compareTo(p2.name);
			}
		});
		map2.put(new Person2("Tom"), 1);
		map2.put(new Person2("Bob"), 2);
		map2.put(new Person2("Lily"), 3);
		for(Person2 key:map2.keySet()) {
			System.out.println(key);
		}
		System.out.println(map2.get(new Person2("Bob")));		
		System.out.println();
		
		Map<Student2, Integer> map3 = new TreeMap<Student2, Integer>(new Comparator<Student2>() {
			public int compare(Student2 s1,Student2 s2) {
				if (s1.score == s2.score) {
					return 0;
				}
				return s1.score > s2.score ? -1 : 1;
			}
		});
		map3.put(new Student2("Tom", 99), 1);
		map3.put(new Student2("Bob", 98), 2);
		map3.put(new Student2("Lily", 100),	3);
		for(Student2 key:map3.keySet()) {
			System.out.println(key);
		}
		System.out.println(map3.get(new Student2("Bob", 98)));
	}

}

class Person2{
	String name;
	public Person2(String name) {
		this.name = name;
	}
	public String toString() {
		return "Person2 "+this.name;
	}
}

class Student2{
	String name;
	int score;
	Student2(String name,int score) {
		this.name = name;
		this.score = score;
	}
	public String toString() {
		return String.format("{%s: score=%d}", name, score);
	}
}