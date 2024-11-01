package object.Three21字符串和编码;

import java.util.Iterator;

public class Main4替换子串_分割字符串_拼接字符串_格式化字符串 {
	public static void main(String args[]) {
		//替换子串
		String s1 = "hello";
		System.out.println(s1.replace("l", "w"));
		System.out.println(s1.replace("ll", "~~"));
		s1 = "A,,B;C ,D";
		System.out.println(s1.replaceAll("[\\,\\;\\s]+", ","));//正则表达式
		//分割字符串
		s1 = "A,B,C,D";
		String[] s2 = s1.split("\\,");//"A,B,C,D"	正则表达式
		System.out.println(s2);
		for (String s : s2) {
			System.out.println(s);
		}
		//拼接字符串
		String[] s3 = {"A","B","C"};
		String s = String.join("***", s3);
		System.out.println(s);
		//格式化字符串
		String s4 = "Hi %s,your score is %d!";
		System.out.println(s4.formatted("Alice",80));
		System.out.println(String.format("Hi %s,your score is %.2f!", "Alice",59.5));
		
	}
}
