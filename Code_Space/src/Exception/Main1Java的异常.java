package Exception;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main1Java的异常 {

	public static void main(String[] args) {

		byte[] bs = toGBK("中文");
		System.out.println(Arrays.toString(bs));
		
	}
	
	static byte[] toGBK(String s) {
		try {
			return s.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
			return s.getBytes();
		}
	}
}
