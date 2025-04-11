package Java8特性;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

public class Main2Lambda表达式2 {

	@Test
	public void test1() {
		Runnable runnable = () -> {System.out.println("test1");};
		runnable.run();
	}
	
	@Test
	public void test2() {
		Consumer<String> consumer = (String s) -> {System.out.println(s);};
		consumer.accept("test2");
	}
	@Test
	public void test3() {
		Consumer<String> consumer = (s) -> {System.out.println(s);};
		consumer.accept("test3");
	}
	@Test
	public void test4() {
		Consumer<String> consumer = s -> {System.out.println(s);};
		consumer.accept("test4");
	}
	@Test
	public void test5() {
		Comparator<Integer> comparator = (o1,o2) -> {
			System.out.println(o1);
			System.out.println(o2);
			return o1.compareTo(o2);
		};
		System.out.println(comparator.compare(1, 2));
	}
	@Test
	public void test6() {
		Comparator<Integer> comparator = (o1,o2) -> Integer.compare(o1, o2);
		System.out.println(comparator.compare(2, 1));
	}
}
