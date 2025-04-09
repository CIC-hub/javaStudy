package IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Main23作业3 {
	public static void main(String[] args) throws IOException {
	/*
	 * (1)要编写一个dog.properties
	 * name = tom
	 * age=5
	 * color= red
	 * (2)编写Dog类(name,age,color)创建一个dog对象，
	 * 读取dog.properties 用相应的内容完成属性初始化,并输出
	 * (3)将创建的Dog对象，序列化到文件dog.dat文件中
	 */
		String filePath = "e:\\hw\\dog.properties";
		Properties p1 = new Properties();
		
		p1.setProperty("name", "tom");
		p1.setProperty("age", "5");
		p1.setProperty("color", "red");
		
		p1.store(new FileWriter(filePath), null);

		Properties p2 = new Properties();
		p2.load(new FileReader(filePath));
		
		String name = p2.getProperty("name");
		String age = p2.getProperty("age");
		String color = p2.getProperty("color");
		
		Dog2 dog = new Dog2(name,age,color);
		System.out.println(dog);
		
		
	}
}

class Dog2{
	private String name;
	public Dog2(String name, String age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dog2 [name=" + name + ", age=" + age + ", color=" + color + "]";
	}

	private String age;
	private String color;

}