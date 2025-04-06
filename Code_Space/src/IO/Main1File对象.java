package IO;
import java.io.*;

public class Main1File对象 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		create1();
		create2();
		create3();
		info();
		m1();
		m2();
		m3();
	}
	
	public static void create1() {
		File f = new File("E:\\notepad.txt");
		try {
			f.createNewFile();
			System.out.println("create1创建成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void create2() {
		File parentFile = new File("E:\\");
		String fileName = "notepad2.txt";
		File file = new File(parentFile,fileName);
		try {
			file.createNewFile();
			System.out.println("create2创建成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void create3() {
		String parentPath = "e:\\";
		String fileName = "notepad3.txt";
		File file = new File(parentPath,fileName);
		try {
			file.createNewFile();
			System.out.println("create3创建成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void info() {
		File file = new File("e:\\notepad.txt");
		
		System.out.println("文件名="+file.getName());
		System.out.println("文件绝对路径="+file.getAbsolutePath());
		System.out.println("文件名父级目录="+file.getParent());
		System.out.println("文件大小（字节）="+file.length());//3+9=12
		System.out.println("文件是否存在="+file.exists());
		System.out.println("是否为文件="+file.isFile());
		System.out.println("是否为目录="+file.isDirectory());
	}
	
	public static void m1() {
		String filePath = "e:\\notepad3.txt";
		File file = new File(filePath);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println(filePath+"删除成功");
			}else {
				System.out.println(filePath+"删除失败");
			}
		}else {
			System.out.println("该文件不存在");
		}
	}
	
	public static void m2() {
		String dirPath = "e:\\demo2";
		File file = new File(dirPath);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println(dirPath+"删除成功");
			}else {
				System.out.println(dirPath+"删除失败");
			}
		}else {
			System.out.println("该目录不存在");
		}
	}
	
	public static void m3() {
		String dirPath = "e:\\a\\b\\c";
		File file = new File(dirPath);
		if (file.exists()) {
			System.out.println(dirPath+"该目录存在");
		}else {
			if (file.mkdirs()) {
				System.out.println(dirPath+"该目录创建成功");
			}else {
				System.out.println(dirPath+"该目录创建失败");
			}
		}
	}
}
