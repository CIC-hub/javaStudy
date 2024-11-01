package object.Three21字符串和编码;

import java.util.Arrays;

public class Main6转换为char数组 {
	public static void main(String args[]) {
		//转换为char[]
		char[] cs = "Hello".toCharArray();// String -> char[]
		System.out.println(cs);
		
		String s1 = new String(cs);// char[] -> String
		System.out.println(s1);
		
		cs[0] = 'X';//如果修改了char[]数组，String并不会改变
		System.out.println(cs);
		System.out.println(s1);
		
		int[] scores = new int[] {88,77,51,66};
		Score s = new Score(scores);
		s.printScores();
		scores[2] = 99;
		s.printScores();
	}
}

class Score{
	private int[] scores;
	public Score(int[] scores) {
		// TODO Auto-generated constructor stub
		this.scores = scores;
	}
	
	public void printScores() {
		System.out.println(Arrays.toString(scores));
	}
}