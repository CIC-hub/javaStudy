package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2FileInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFile1();
		System.out.println();
		readFile2();

	}
	
	private static void readFile1() {
		String filePath = "e:\\hello.txt";
		int readData = 0;
		//创建FileInputStream对象，用于读取文件
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			//从该输入流读取1个字节的数据。如果没有输入可用，该方法将阻止
			//返回-1表示读取完毕
			while ((readData = fileInputStream.read()) != -1) {
				System.out.print((char)readData);//转成char显示
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭文件流，释放资源
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void readFile2() {
		String filePath = "e:\\hello.txt";
		byte[] readData = new byte[8];
		int readLen = 0;
		//创建FileInputStream对象，用于读取文件
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			//返回读取的字节数，返回-1表示读取完毕
			while ((readLen = fileInputStream.read(readData)) != -1) {
				System.out.print(new String(readData,0,readLen));//转成char显示
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭文件流，释放资源
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
