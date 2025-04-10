package Java8特性;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

public class Main2Lambda表达式2 {

	@Test
	public void test1() {
		Runnable runnable = () -> {System.out.println("hello");};
		runnable.run();
	}
	
	@Test
	public void test2() {
		Consumer<String> consumer = (String s) -> {System.out.println(s);};
		consumer.accept("world");
	}
	@Test
	public void test3() {
		Consumer<String> consumer = (s) -> {System.out.println(s);};
		consumer.accept("world");
	}
	@Test
	public void test4() {
		Consumer<String> consumer = s -> {System.out.println(s);};
		consumer.accept("world");
	}
	@Test
	public void test5() {
		
	}
	@Test
	public void test6() {
		
	}
}
