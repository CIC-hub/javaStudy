package collection;

import java.util.LinkedList;
import java.util.Queue;

public class Main9使用Queue {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		try {
			queue.add("Apple");
			System.out.println("success");	
		} catch (IllegalStateException  e) {
			System.out.println("fail");
		}
		Queue<String> queue2 = new LinkedList<String>();
		if (queue2.offer("Apple")) {
			System.out.println("success");	
		}else {
			System.out.println("fail");
		}System.out.println();
		
//		Queue<String> queue3 = new LinkedList<>();
//		try {
//			String string = queue3.remove();
//			System.out.println("success");
//		} catch (IllegalStateException e) {
//			System.out.println("fail");
//		}
		
		Queue<String> queue4 = new LinkedList<String>();
		String string2 = queue4.poll();
		if (string2 != null) {
			System.out.println("success");	
		}else {
			System.out.println("fail");
		}System.out.println();
		
		Queue<String> queue5 = new LinkedList<String>();
		queue5.offer("Apple");
		queue5.offer("Banana");
		System.out.println(queue5.poll());
		System.out.println(queue5.poll());
		System.out.println(queue5.poll());
		System.out.println();
		
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.peek());

	}

}
