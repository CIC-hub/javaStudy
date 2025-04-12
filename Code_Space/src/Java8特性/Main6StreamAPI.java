package Java8特性;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class Main6StreamAPI {

	//1通过集合创建Stream
	@Test
	public void test1() {
		List<Employee> employees = EmployeeData.getEmployees();
		
		//default Stream<E> stream()：返回一个顺序流
		Stream<Employee> stream = employees.stream();
	
		//default Stream<E> parallelStream()：返回一个并行流
		Stream<Employee> parallelStream = employees.parallelStream();
	}
	
	//2通过数组创建Stream
	@Test
	public void test2() {
		int[] arr = new int[] {1,2,3,4,5};
		IntStream stream = Arrays.stream(arr);
		
		Employee e1 = new Employee(1,"a");
		Employee e2 = new Employee(2,"b");
		Employee[] arr1 = new Employee[] {e1,e2};
		Stream<Employee> stream2 = Arrays.stream(arr1);
	}
	
	//3通过Stream的of
	@Test
	public void test3() {
		Stream<Integer> stream = Stream.of(1,2,3,4,5);	
	}
	
	//4创建无限流
	@Test
	public void test4() {
		//迭代
		//public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
		//遍历前10个偶数
		Stream.iterate(0, t -> t+2).limit(10).forEach(System.out::println);;
	
		//生成
		//public static<T> Stream<T> generate(Supplier<T> s)
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
	}
}
