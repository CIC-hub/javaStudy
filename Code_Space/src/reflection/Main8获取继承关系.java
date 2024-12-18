package reflection;

import java.util.Iterator;

public class Main8获取继承关系 {

	public static void main(String[] args) throws Exception{
		Class s = Integer.class;
		Class n = s.getSuperclass();
		Class o = n.getSuperclass();
		System.out.println(n);
		System.out.println(o);
		System.out.println(o.getSuperclass());
		System.out.println();
		
		Class[] is = s.getInterfaces();
		for(Class i:is) {
			System.out.println(i);
		}System.out.println();
		
		Class[] in = n.getInterfaces();
		for(Class i:in) {
			System.out.println(i);
		}System.out.println();
		
		System.out.println(java.io.DataInputStream.class.getSuperclass()); 
		// java.io.FilterInputStream，因为DataInputStream继承自FilterInputStream
		System.out.println(java.io.Closeable.class.getSuperclass());
		// null，对接口调用getSuperclass()总是返回null，获取接口的父接口要用getInterfaces()
		System.out.println();
		
		System.out.println(Integer.class.isAssignableFrom(Integer.class));
		System.out.println(Number.class.isAssignableFrom(Integer.class));
		System.out.println(Object.class.isAssignableFrom(Integer.class));
		System.out.println(Integer.class.isAssignableFrom(Number.class));

	}

}
