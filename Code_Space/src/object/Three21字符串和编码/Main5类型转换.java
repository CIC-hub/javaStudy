package object.Three21字符串和编码;

public class Main5类型转换 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//转为String
		System.out.println(String.valueOf(123));
		System.out.println(String.valueOf(45.67));
		System.out.println(String.valueOf(true));
		System.out.println(String.valueOf(new Object()));
		
		//String转为其他
		int n1 = Integer.parseInt("123");
		int n2 = Integer.parseInt("ff",16);
		System.out.println(n1+" "+n2);
		
		boolean b1 = Boolean.parseBoolean("true");
		boolean b2 = Boolean.parseBoolean("FALSE");
		boolean b3 = Boolean.parseBoolean("fd");
		System.out.println(b1+" "+b2+" "+b3);
	
		System.out.println(Integer.getInteger("java.version"));	//把该字符串对应的系统变量转换为Integer。版本号
			
	}

}
