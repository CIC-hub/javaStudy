package Exception;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main3Java的异常3 {

	public static void main(String[] args) throws Exception{

			byte[] bs = toGBK("中文");
			System.out.println(Arrays.toString(bs));
			
	}
		
		static byte[] toGBK(String s) throws UnsupportedEncodingException{
			return s.getBytes("GBK");
		}

}
