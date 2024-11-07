package collection;

import java.util.Iterator;
import java.util.List;

public class Main3List和Array转换 {
	public static void main(String[] args) {
		List<String> list = List.of("apple","pear","banana");
		Object[] array = list.toArray();
		for(Object s:array) {
			System.out.println(s);
		}
		
		List<Integer> list2 = List.of(12,34,56);
		Integer[] array2 = list2.toArray(new Integer[3]);
		for(Integer n:array2) {
			System.out.println(n);
		}System.out.println();
		
		Number[] array3 = list2.toArray(new Number[3]);
		for(Number n:array3) {
			System.out.println(n);
		}System.out.println();
		
		Integer[] array4 = list2.toArray(new Integer[list2.size()]);
		for(Number n:array4) {
			System.out.println(n);
		}System.out.println();
		
		Integer[] array5 = list2.toArray(Integer[]::new);
		for(Number n:array5) {
			System.out.println(n);
		}
		
		Integer[] array6 = {1,2,3};
		List<Integer> list3 = List.of(array6);
		System.out.println(list3);
		
//		list3.add(999);//UnsupportedOperationException
	}
}
