package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main19传统方法读取properties文件 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = "e:\\mysql.properties";
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = "";
		
		while ((line = br.readLine()) != null) {
			String[] split = line.split("=");
//			System.out.println(split[0] + "值是" + split[1]);
			if ("ip".equals(split[0])) {
				System.out.println(split[0] + "值是" + split[1]);		
			}
		}
		br.close();
	}

}
