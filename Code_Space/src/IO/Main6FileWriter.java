package IO;

import java.io.FileWriter;
import java.io.IOException;

public class Main6FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeFile();
	}
	
	private static void writeFile() {
		String filePath = "e:\\fileWriter.txt";
		FileWriter fileWriter = null;
		char[] ch = {'B','C','D'};
		try {
			fileWriter = new FileWriter(filePath,true);
			fileWriter.write("A");
			fileWriter.write(ch);
			fileWriter.write(ch, 2, 1);
			fileWriter.write("中文");
			fileWriter.write("三月25日",2,3);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileWriter.close();
//				fileWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("程序结束");
	}
}
