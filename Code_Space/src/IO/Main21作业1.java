package IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main21作业1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
 * (1)在判断e盘下是否有文件夹hw如果没有就创建hw
 * (2)在e:\\hw目录下，创建文件hello.txt
 * (3)如果hello.txt已经存在，提示该文件已经存在，就不要再重复创建了
 * (4)并且在hello.txt文件中，写入hello,world
 */
		String dirPath = "e:\\hw";
		File dir = new File(dirPath);
		if (dir.exists()) {
			System.out.println(dirPath+"文件夹存在");
		}else {
			if(dir.mkdirs()) {
				System.out.println(dirPath+"文件夹创建成功");
			}else {
				System.out.println(dirPath+"文件夹创建失败");
			}
		}
		
//		String filePath = "e:\\hw\\hello.txt";
		String filePath = dirPath + "\\hello.txt";
		File file = new File(filePath);
		if (file.exists()) {
			System.out.println(filePath+"文件存在");
		}else {
			if(file.createNewFile()) {
				System.out.println(filePath+"文件创建成功");
			}else {
				System.out.println(filePath+"文件创建失败");
			}
		}
		FileWriter fw = new FileWriter(file);
		fw.write("你好hello,world!");
		System.out.println(filePath+"写入成功");
		fw.close();
	}

}
