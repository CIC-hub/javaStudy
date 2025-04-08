package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main18PrintWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//输出到显示器
		PrintWriter pw = new PrintWriter(System.out);
		pw.print("hi,你好！");
		pw.close();
		
		PrintWriter pw2 = new PrintWriter(new FileWriter("e:\\PrintWriter.txt"));
		pw2.print("hi,你好2！");
		pw2.close();//flush + 关闭流，才会把数据写入文件
	}

}
