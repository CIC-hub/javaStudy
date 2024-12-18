package Exception;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main2Java的异常2 {
	public static void main(String[] args) {
		try {
			byte[] bs = toGBK("中文");
			System.out.println(Arrays.toString(bs));
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
		}	
	}
	
	static byte[] toGBK(String s) throws UnsupportedEncodingException{
		return s.getBytes("GBK");
	}
}
