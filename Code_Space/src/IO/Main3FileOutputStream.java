package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main3FileOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeFile();
	}
	
	private static void writeFile() {
		//创建FileOutputStream对象
		String filePath = "e:\\writeFile.txt";
		FileOutputStream fileOutputStream = null;
		
		try {
//覆盖写法			
//			fileOutputStream = new FileOutputStream(filePath);
//追加写法
			fileOutputStream = new FileOutputStream(filePath,true);

			//写入1个字节，自动把char -> int
//			fileOutputStream.write('a');
			//把字符串 -> 字符数组
//			fileOutputStream.write("hello,world!".getBytes());
			//第2个字节开始，5个长度
			fileOutputStream.write("hello,world!".getBytes(),2,5);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
