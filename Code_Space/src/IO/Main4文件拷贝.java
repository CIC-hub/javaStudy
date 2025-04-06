package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main4文件拷贝 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileCopy();
	}

	private static void fileCopy() {
		String srcFilePath = "e:\\pic1.jpg";
		String dirtFilePath = "e:\\pic2.jpg";
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		
		try {
			fileInputStream = new FileInputStream(srcFilePath);
			fileOutputStream = new FileOutputStream(dirtFilePath);
			byte[] readData = new byte[1024];
			int readLen = 0;
			while ((readLen = fileInputStream.read(readData)) != -1) {
				fileOutputStream.write(readData,0,readLen);
			}
			System.out.println("拷贝完成");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}		
		}
	}
}
