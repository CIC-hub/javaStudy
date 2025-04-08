package IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15InputStreamReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String  filePath = "e:\\InputStreamReader.txt";
		String charSet = "gbk";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charSet));
		
		String string = br.readLine();
		System.out.println(string);
		br.close();
	}

}
