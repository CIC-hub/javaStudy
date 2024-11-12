package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main5使用Map {

	public static void main(String[] args) {
		Student student = new Student("xiao ming",99);
		Map<String, Student> map = new HashMap<>();
		map.put("xiao ming", student);
		Student targetStudent = map.get("xiao ming");
		System.out.println(targetStudent==student);
		System.out.println(targetStudent.score);
		Student anotherStudent = map.get("Bob");
		System.out.println(anotherStudent);
		System.out.println();
		
		Student student2 =  new Student("xiao hong", 100);
		map.put("xiao hong", student2);
		System.out.println(map.get("xiao ming").score);
		map.put("xiao ming", student2);
		System.out.println(map.get("xiao ming").score+map.get("xiao ming").name);
		System.out.println();
		
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("apple", 1);
		map2.put("pear", 2);
		map2.put("banana", 3);
		for(String key:map2.keySet()) {
			System.out.println(key+" "+map2.get(key));
		}
		System.out.println();
		
		for(Map.Entry<String, Integer> entry:map2.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}

}

class Student{
	public String name;
	public int score;
	public Student(String name,int score) {
		this.name = name;
		this.score = score;
	}
}