package Java8特性;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Main9StreamAPI4排序 {

	@Test
	public void test1() {
	//sorted()自然排序
		List<Integer> list = Arrays.asList(1,2,3,4,5,0,9,-1);
		list.stream().sorted().forEach(System.out::println);
	//类使用sorted()要实现Comparable接口
		
	//sorted(Comparator com)定制排序
		List<Employee> employees = EmployeeData.getEmployees();
		employees.stream().sorted((e1,e2) -> -Integer.compare(e1.getAge(), e2.getAge())).forEach(System.out::println);
		System.out.println();
		
		employees.stream().sorted((e1,e2) -> {
			int ageValue = -Integer.compare(e1.getAge(), e2.getAge());
			if (ageValue != 0) {
				return ageValue;
			}else {
				return -Double.compare(e1.getSalary(), e2.getSalary());
			}			 
		}).forEach(System.out::println);
		
	}
}
