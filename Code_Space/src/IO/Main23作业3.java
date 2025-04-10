package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;

public class Main23作业3 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	/*
	 * (1)要编写一个dog.properties
	 * name = tom
	 * age=5
	 * color= red
	 * (2)编写Dog类(name,age,color)创建一个dog对象，
	 * 读取dog.properties 用相应的内容完成属性初始化,并输出
	 * (3)将创建的Dog对象，序列化到文件dog.dat文件中
	 */
		String filePath = "d:\\hw\\dog.properties";
		Properties p1 = new Properties();
		
		p1.setProperty("name", "tom");
		p1.setProperty("age", "5");
		p1.setProperty("color", "red");
		
		p1.store(new FileWriter(filePath), null);

		Properties p2 = new Properties();
		p2.load(new FileReader(filePath));
		
		String name = p2.getProperty("name");
		int age = Integer.parseInt(p2.getProperty("age"));
		String color = p2.getProperty("color");
		
		Dog2 dog = new Dog2(name,age,color);
		System.out.println(dog);
		
		String filePath2 = "d:\\hw\\dog.dat";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath2) );
		oos.writeObject(dog);
		oos.close();
		m1(filePath2);
		
	}
	
	public static void m1(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("反序列化"); 
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
		Dog2 dog2 = (Dog2)ois.readObject();
		System.out.println(dog2);
		ois.close();
	}
}

class Dog2 implements Serializable{
	private String name;
	public Dog2(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dog2 [name=" + name + ", age=" + age + ", color=" + color + "]";
	}

	private int age;
	private String color;

}