package Java8特性;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class Main10Stream终止操作匹配与查找 {
	
	@Test
	public void test1() {
		List<Employee> employees = EmployeeData.getEmployees();
		//allMatch(Predicate p)检查是否匹配所有元素
		boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 5);
		System.out.println(allMatch);
		
		//anyMatch(Predicate p)检查是否至少匹配一个元素
		boolean anyMatch = employees.stream().anyMatch(e -> e.getId() > 1002);
		System.out.println(anyMatch);
		
		//noneMatch(Predicate p)检查是否没有匹配的元素
		boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("a"));
		System.out.println(noneMatch);
		
		//findFirst返回第一个元素
		Optional<Employee> first = employees.stream().findFirst();
		System.out.println(first);
		
		//findAny返回当前流中的任意元素
		Optional<Employee> any = employees.parallelStream().findAny();
		System.out.println(any);
	}
	
	@Test
	public void test2() {
		List<Employee> employees = EmployeeData.getEmployees();
		
		//count返回流中元素的总个数
		long count = employees.stream().filter(e -> e.getId() > 1005).count();
		System.out.println(count);
		
		//max(Comparator c)返回流中最大值
		Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
		Optional<Double> maxSalary = salaryStream.max(Double::compare);
		System.out.println(maxSalary);
		
		//min(Comparator c)返回流中最小值
		Optional<Employee> employee = employees.stream().min((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(employee);
		
		//forEach(Comsumer c)内部迭代
		employees.stream().forEach(System.out::println);
		//集合里的默认方法
		employees.forEach(System.out::println);
		//使用迭代器的是外部迭代
	}
}
