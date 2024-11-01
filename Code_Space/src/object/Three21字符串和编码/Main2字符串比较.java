package object.Three21字符串和编码;

public class Main2字符串比较 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello";
		String s2 = "Hello";
		
		System.out.println("1."+s1 == s2);
		System.out.println("2."+s1.equals(s2));
		
		String s3 = "hello";
		String s4 = "HELLO".toLowerCase();
		
		System.out.println("3."+s3 == s4);
		System.out.println("4."+s3.equals(s4));
		
		System.out.println("5."+s3.equalsIgnoreCase("Hello"));
		
		System.out.println("6."+"Hello".contains("ll"));
		
		System.out.println("Hello".indexOf("l"));
		System.out.println("Hello".lastIndexOf("l"));
		System.out.println("Hello".startsWith("He"));
		System.out.println("Hello".endsWith("lo"));

		System.out.println("Hello".substring(1));
		System.out.println("Hello".substring(1,4));

	}
}
