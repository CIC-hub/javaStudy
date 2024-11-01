package object.objects_classes;

public class Person2 {
	public void printInfo(String[] str) {
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
	}
	
	//...方法的可变个数的参数，多个参数时需放最后
	public void printInfo2(String... str) {
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
	}
	
}
