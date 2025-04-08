package IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main22作业2 {
	public static void main(String[] args) throws IOException {
/*
 * 要求:使用BufferedReader读取一个文本文件，
 * 为每行加上行号，再连同内容一并输出到屏幕上。
 */
		String filePath = "e:\\hw\\hw2.txt";
//		默认utf8
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		
		String line = "";
		int i = 0;
		while ((line = br.readLine()) != null) {
//			i++;
			System.out.println(++i+":"+line);
		}
		br.close();
		
//转换流解决中文编码错误
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));
		String line2 = "";
		int i2 = 0;
		while ((line2 = br2.readLine()) != null) {
//			i++;
			System.out.println(++i2+":"+line2);
		}
		br2.close();
	}
}
