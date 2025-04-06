package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main8BufferedWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String filePath = "e:\\BufferedWriter.txt";
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));//覆盖
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));//追加	
		bufferedWriter.write("hello1");
		bufferedWriter.newLine();//换行
		bufferedWriter.write("hello2");
		bufferedWriter.newLine();
		bufferedWriter.write("hello3");
		bufferedWriter.newLine();

		bufferedWriter.close();
	}

}
