package Java8特性;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

public class Main5构造器引用与数组引用 {

	//构造器引用
	//Supplier中的T get()
	//Employee中的空参构造器：Employee()
	@Test
	public void test1() {
		System.out.println("test1");
		Supplier<Employee> sup1 = () -> new Employee();
		System.out.println(sup1.get());
		
		Supplier<Employee> sup2 = Employee::new;
		System.out.println(sup2.get());
	}
	
	//Function中的R apply(T t)
	@Test
	public void test2() {
		System.out.println("test2");
		Function<Integer, Employee> fun1 = id -> new Employee(id);
		System.out.println(fun1.apply(11));
		
		Function<Integer, Employee> fun2 = Employee::new;
		System.out.println(fun2.apply(22));
	}
	
	//BiFunction中的R apply(T t,U u)
	@Test
	public void test3() {
		System.out.println("test3");
		BiFunction<Integer, String, Employee> fun1 = (id,name) -> new Employee(id,name);
		System.out.println(fun1.apply(1, "a"));
		
		BiFunction<Integer, String, Employee> fun2 = Employee::new;
		System.out.println(fun2.apply(2, "b"));
	}
	
	//数组引用
	//Function中的R apply(T t)
	@Test
	public void test4() {
		System.out.println("test4");
		Function<Integer, String[]> fun1 = length -> new String[length];
		String[] arr1 = fun1.apply(5);
		System.out.println(Arrays.toString(arr1));
		
		Function<Integer, String[]> fun2 = String[]::new;
		String[] arr2 = fun2.apply(10);
		System.out.println(Arrays.toString(arr2));
	}
}
