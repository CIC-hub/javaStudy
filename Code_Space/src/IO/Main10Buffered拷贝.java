package IO;

import java.io.*;

public class Main10Buffered拷贝 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String srcFilePath = "e:\\BufferedCopy1.txt";
		String destFilePath = "e:\\BufferedCopy2.txt";
		String line;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader(srcFilePath));
			bw = new BufferedWriter(new FileWriter(destFilePath));
			
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
			System.out.println("OK");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
