package IO;

import java.io.IOException;
import java.io.PrintStream;

public class Main17PrintStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PrintStream out = System.out;
		
		//PrintStream默认输出位置为标准输出（显示器）
		out.print("john,hello");
		
		//print底层用的是write
		out.write("你好".getBytes());
		out.close();
		
		//修改打印流输出位置
		//public static void setOut(PrintStream out) {
        //checkIO();
        //setOut0(out);	//native方法，修改了out
		//}
		System.setOut(new PrintStream("e:\\PrintStream.txt"));
		System.out.println("hello你好！");
	}

}
