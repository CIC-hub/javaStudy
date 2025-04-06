package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//字符输入
public class Main5FileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFile1();
		readFile2();
	}
	
	private static void readFile1() {
		System.out.println("readFile1");
		String filePath = "e:\\fileReader.txt";
		FileReader fileReader = null;
		int readData = 0;
		
		try {
			fileReader = new FileReader(filePath);
			while ((readData = fileReader.read()) != -1 ) {
				System.out.print((char)readData);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void readFile2() {
		System.out.println("readFile2");
		String filePath = "e:\\fileReader.txt";
		FileReader fileReader = null;
		
		char[] buf = new char[8];
		int readLen = 0;
		
		try {
			fileReader = new FileReader(filePath);
			while ((readLen = fileReader.read(buf)) != -1 ) {
				System.out.print(new String(buf,0,readLen));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
