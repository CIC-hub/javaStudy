package Java8特性;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class Main11Stream终止操作归约 {

	@Test
	public void test1() {
		//reduce(T identity,BinaryOperator b)
		//可以将流中元素反复结合起来，得到一个值。返回T
		//BinaryOperator<T> entends BiFunction<T,T,T> 传入两个返回一个
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Integer sum = list.stream().reduce(0,Integer::sum);
		System.out.println(sum);
		Integer sum2 = list.stream().reduce(10,Integer::sum);
		System.out.println(sum2);
		
		//reduce(BinaryOperator b)
		//可以将流中元素反复结合起来，得到一个值，返回Opetional<T>
		List<Employee> employees = EmployeeData.getEmployees();
		Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
		Optional<Double> sumMoney = salaryStream.reduce((d1,d2) -> d1+d2);
//		Optional<Double> sumMoney = salaryStream.reduce(Double::sum);
		System.out.println(sumMoney);
	}
}
