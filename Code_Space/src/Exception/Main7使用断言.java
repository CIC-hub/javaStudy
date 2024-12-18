package Exception;

public class Main7使用断言 {

	public static void main(String[] args) {
		double x = -1.2;
		assert x >= 0 : "x must >= 0";
		//这是因为JVM默认关闭断言指令，即遇到assert语句就自动忽略了，不执行。
		//Run as--Arguments--VM Arguments:-enableassertions或-ea
		System.out.println(x);
	}

}
