package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main16OutputStreamWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = "e:\\OutputStreamWriter.txt";
		String charSet = "utf-8";
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),charSet);
		osw.write("12你好");
		osw.close();
		System.out.println(charSet+"写入完成");
	}

}
