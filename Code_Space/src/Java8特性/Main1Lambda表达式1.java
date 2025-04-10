package Java8特性;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class Main1Lambda表达式1 {
	@Test
	public void test1() {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("test1");
			}
		};
		runnable.run();
		
		Runnable runnable2 = () -> System.out.println("1test");
		runnable2.run();
	}
	
	@Test
	public void test2() {
		Comparator<Integer> comparator =new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		};
		System.out.println(comparator.compare(1, 2));
		//Lambda表达式
		Comparator<Integer> comparator2 = (o1,o2) -> Integer.compare(o1,o2);
		System.out.println(comparator2.compare(2, 1));
		//方法引用
		Comparator<Integer> comparator3 = Integer::compare;
		System.out.println(comparator3.compare(2, 3));
	}
}
