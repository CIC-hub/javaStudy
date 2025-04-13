package Java8特性;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class Main12Stream终止操作收集 {
	@Test
	public void test() {
		//collect(Collector c)将流转换为其他形式
		//接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
		List<Employee> employees = EmployeeData.getEmployees();
		List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 50).collect(Collectors.toList());		
		employeeList.forEach(System.out::println);
		
		System.out.println();
		
		Set<Employee> employeeList2 = employees.stream().filter(e -> e.getSalary() > 50).collect(Collectors.toSet());
		employeeList2.forEach(System.out::println);
	}
}
