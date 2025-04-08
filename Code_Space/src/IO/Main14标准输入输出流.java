package IO;

import java.util.Scanner;

public class Main14标准输入输出流 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System类的public final static InputStream in = null
		//System.in的编译类型 InputStream
		//System.in的运行类型 BufferedInputStream
		//表示标准输入	键盘
		System.out.println(System.in.getClass());
		
		//System.out public final static PrintStream out = null
		//编译类型 PrintStream
		//运行类型 PrintStream
		//表示标准输出	显示器
		System.out.println(System.out.getClass());
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入");
		String next = scanner.next();
		System.out.println("next=" + next);
		
	}

}
