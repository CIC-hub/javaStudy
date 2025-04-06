package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main13ObjectInputStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String filePath = "e:\\ObjectOutputStream.txt";
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
		
		System.out.println(ois.readInt());
		System.out.println(ois.readBoolean());
		System.out.println(ois.readChar());
		System.out.println(ois.readDouble());
		System.out.println(ois.readUTF());
		
		//dog的编译类型时Object，dog的运行类型是Dog
		Object dog = ois.readObject();
		System.out.println("运行类型="+dog.getClass());
		System.out.println("dog信息="+dog);
		
		//调用Dog的方法，要向下转型
		//Dog类的定义要在可以引用的位置
		Dog dog2 = (Dog)dog;
		System.out.println(dog2.getName());
		
		ois.close();
	}

}
