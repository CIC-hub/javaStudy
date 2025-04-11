package Java8特性;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

public class Main4方法引用1 {

	//对象::实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		PrintStream ps = System.out;
		Consumer<String> con = ps::println;
		con.accept("test1");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1, "emp", 11, 111);
		Supplier<String> sup = emp::getName;
		System.out.println(sup.get());
	}
	
	
	//类::静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com = Integer::compare;
		System.out.println(com.compare(1, 2));
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double, Long> fun = Math::round;
		System.out.println(fun.apply(1.1));//四舍五入
	}
	
	//类::实例方法
	//Comparator中的int compare(T t1,T t2)
	//String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com = String::compareTo;
		System.out.println(com.compare("ab", "ad"));
	}
	
	//BiPredicate中的boolean test(T t1,T t2)
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String, String> pre = String::equals;
		System.out.println(pre.test("ab", "ab"));
	}
	
	//Function中的R apply(T t)
	//Employee中的String getName()
	@Test
	public void test7() {
		Employee e = new Employee(1, "a", 11, 111);
		Function<Employee, String> fun = Employee::getName;
		System.out.println(fun.apply(e));
	}
	
	public static List<Employee> getEmployees(){
		List<Employee> list = new ArrayList<Employee>();
		
		list.add(new Employee(1001, "a", 1, 11));
		list.add(new Employee(1002, "b", 2, 22));
		list.add(new Employee(1003, "c", 3, 33));
		list.add(new Employee(1004, "d", 4, 44));
		list.add(new Employee(1005, "e", 5, 55));
		list.add(new Employee(1006, "f", 6, 66));
		list.add(new Employee(1007, "g", 7, 77));
		list.add(new Employee(1008, "h", 8, 88));
		
		return list;
	}
}
