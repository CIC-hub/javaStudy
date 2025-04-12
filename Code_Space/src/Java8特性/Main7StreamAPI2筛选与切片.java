package Java8特性;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class Main7StreamAPI2筛选与切片 {

	//1.筛选与切片
	@Test
	public void test1() {
		List<Employee> list = new EmployeeData().getEmployees();
		Stream<Employee> stream = list.stream();
		
		//filter(Predicate p) --接收Lambda，从流中排除某些元素		
		System.out.println("filter");
		stream.filter(e -> e.getSalary()>50).forEach(System.out::println);
		//stream已关闭
		
		//limit(n) --截断流，使其元素不超过给定数量
		System.out.println("limit");
		list.stream().limit(3).forEach(System.out::println);
		
		//skip(n) --跳过元素，返回除去前n个元素的流，若元素不足n个，则返回空流，与limit(n)互补
		System.out.println("skip");
		list.stream().skip(3).forEach(System.out::println);
		
		
		//distinct() --筛选，通过流所生成元素的hashCode()和equals()去除重复元素
		System.out.println("distinct");
		
		list.add(new Employee(1010,"a",10,99));
		list.add(new Employee(1010,"a",10,99));
		list.add(new Employee(1010,"a",10,99));
		list.add(new Employee(1010,"a",10,99));
		list.add(new Employee(1011,"a",10,99));
		
		list.stream().distinct().forEach(System.out::println);;
	}
	
	
	@Test
	public void test2() {
		System.out.println(2);
	}
}
