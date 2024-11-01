package object.Three21字符串和编码;

import java.nio.charset.StandardCharsets;

public class Main8字符编码 {

	public static void main(String[] args) {
		//
		byte[] b1 = "Hello".getBytes();
//		byte[] b2 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
//		byte[] b3 = "Hello".getBytes("GBK");
		byte[] b4 = "Hello".getBytes(StandardCharsets.UTF_8);

		System.out.println(b1);	
		
		System.out.println(b4);
		
		for(byte b : b1) {
			System.out.println(b);//H e l l o
		}
		
		//byte[] --> String
		byte[] b = b4;
//		String s1 = new String(b,"GBK");
		String s2 = new String(b,StandardCharsets.UTF_8);
		
		System.out.println(s2);
	}	
}

