package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main12ObjectOutputStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//序列化后，保存的文件格式不是文本，而是它的格式
		String filePath = "e:\\ObjectOutputStream.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
		
		oos.writeInt(100);//int -> Integer（实现了Serializable）
		oos.writeBoolean(true);//boolean -> Bollean（实现了Serializable）
		oos.writeChar('a');//char -> Character（实现了Serializable）
		oos.writeDouble(9.5);//double -> Double（实现了Serializable）
		oos.writeUTF("一二三");//String（实现了Serializable）
		
		oos.writeObject(new Dog("旺财",10));
		
		oos.close();
		System.out.println("序列化保存完毕");
	}

}

class Dog implements Serializable{
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}

	private String name;
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private int age;
	
	

	
}