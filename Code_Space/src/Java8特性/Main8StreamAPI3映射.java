package Java8特性;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import object.objects_classes.a;

public class Main8StreamAPI3映射 {

//map(Function f)接收一个函数作为参数，将元素转换成其他形式/提取信息
//该函数会被应用到每个元素上，并将其映射成一个新的元素
	@Test
	public void test1() {
		System.out.println("test1");
		List<String>list = Arrays.asList("aa","bb","cc","dd");
		list.stream().map(s -> s.toUpperCase()).forEach(System.out::print);
		System.out.println();
		list.stream().map(String::toUpperCase).forEach(System.out::print);
		System.out.println();
	}
	
	@Test
		public void test2() {
		System.out.println("test2");
		List<Employee>employees = EmployeeData.getEmployees();
		Stream<String> nameStream = employees.stream().map(e -> e.getName());
		nameStream.filter(name -> name.length()>1).forEach(System.out::print);
		System.out.println();
		employees.stream().map(Employee::getId).filter(id -> id>1003).forEach(System.out::print);
		System.out.println();
	}
	
//flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连成一个流
	@Test
	public void test3() {
		System.out.println("test3");
		List<String>list = Arrays.asList("aa","bb","cc","dd");
		
		Stream<Stream<Character>> streamstream = list.stream().map(Main8StreamAPI3映射::fromStringToStream);
		streamstream.forEach(s ->{
			s.forEach(System.out::print);
		});
		System.out.println();
		Stream<Character> flatMap = list.stream().flatMap(Main8StreamAPI3映射::fromStringToStream);
		flatMap.forEach(System.out::print);
	}
	
	
	public static Stream<Character> fromStringToStream(String str) {
		ArrayList<Character> arrayList = new ArrayList<Character>();
		for (Character c : str.toCharArray()) {
			arrayList.add(c);
		}
		return arrayList.stream();
	}

}
