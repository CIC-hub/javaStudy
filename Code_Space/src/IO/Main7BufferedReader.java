package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main7BufferedReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String filePath = "e:\\BufferedReader.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		bufferedReader.close();
		
	}

}
