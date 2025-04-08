package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main20使用Properties {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		getInfo();
		create_edit();
	}
	
	public static void getInfo() throws FileNotFoundException, IOException {
		System.out.println("获取信息");
		String filePath = "e:\\mysql.properties";
		Properties properties = new Properties();
		properties.load(new FileReader(filePath));
		//把k-v显示控制台
		properties.list(System.out);
		
		String user = properties.getProperty("user");
		String pwd = properties.getProperty("pwd");

		System.out.println("用户名是" + user);
		System.out.println("密码是" + pwd);
	}
	
	public static void create_edit() throws FileNotFoundException, IOException {
		System.out.println("创建和修改");
		String filePath = "e:\\mysql2.properties";
		Properties properties = new Properties();
		
		//Properties父类是Hashtable，底层是Hashtable，核心方法见setProperty源码
		properties.setProperty("charset", "utf8");
		properties.setProperty("user", "汤姆");
		properties.setProperty("pwd", "123");

		properties.store(new FileOutputStream(filePath), "hello world + 此处是注释");
		System.out.println("保存完毕");
		
		properties.setProperty("pwd", "abc");
		properties.store(new FileOutputStream(filePath), "hello world + 此处是注释");
		System.out.println("修改完毕");
	}
}
