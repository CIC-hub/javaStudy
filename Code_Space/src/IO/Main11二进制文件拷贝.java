package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main11二进制文件拷贝 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String srcFilePath = "e:\\Main11二进制文件拷贝1.txt";
//		String destFilePath = "e:\\Main11二进制文件拷贝2.txt";
		String srcFilePath = "e:\\pic1.jpg";
		String destFilePath = "e:\\pic3.jpg";
	
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(srcFilePath));
			bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
			
			byte[] buff = new byte[1024];
			int readLen = 0;
			
			while ((readLen = bis.read(buff)) != -1) {
				bos.write(buff,0,readLen);
			}
			
			System.out.println("OK");
			
		} catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();				
				}
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
	}

}
