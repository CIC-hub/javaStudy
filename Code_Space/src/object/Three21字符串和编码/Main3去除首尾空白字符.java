package object.Three21字符串和编码;

public class Main3去除首尾空白字符 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "  \tHello\r\n ";
		
		System.out.println(s.trim());
		System.out.println(s);
		
		s = "\u3000Hello\u3000";	//中文空格字符
		System.out.println(s.trim());
		System.out.println(s.strip());
		System.out.println(s);
		
		System.out.println("".isEmpty());
		System.out.println(" ".isEmpty());
		System.out.println(" \n".isBlank());
		System.out.println(" Hello ".isBlank()); 
		
	}

}
