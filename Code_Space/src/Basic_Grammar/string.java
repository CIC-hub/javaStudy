package Basic_Grammar;

public class string {
	public static void main(String[] args){
		String str1 = String.join("/", "S","M","L","XL");
		System.out.println(str1);
		
		String s1 ="a",s2 = "b",s3 = "c";
		String str2 = "";
		StringBuilder builder = new StringBuilder();
		builder.append(s1);str2 = builder.toString();System.out.println(str2);
		builder.append(s2);str2 = builder.toString();System.out.println(str2);
		builder.append(s3);str2 = builder.toString();System.out.println(str2);
		
		int a = 2147483647;
		int b =	a/2;
		double c;
		b += 1;
		c = Math.log(b)/Math.log(2);
		System.out.println(c);
		
	}
}
