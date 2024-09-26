package Basic_Grammar;

import java.util.Arrays;

public class array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		int[] a = {1,2,3,4,5};
		System.out.println(Arrays.toString(a));
//		
		if(args.length == 0 || args[0].equals("-h"))
			System.out.print("Hello,");
		else if(args[0].equals("-g"))
			System.out.print("Goodbye,");
		for(int i = 1;i	< args.length;i++)
			System.out.print(" "+args[i]);
		System.out.print("!");
		
//
		int k=5,n=50;
		
		int[] numbers = new int[n];
		for(int i=0;i<numbers.length;i++)
			numbers[i] = i+1;
		
		int[] results = new int[k];
		
		for(int i=0;i<results.length;i++) {
			int r = (int)(Math.random()*n);
			results[i] = numbers[r];
			
			numbers[r] = numbers[n-1];
			n--;
		}
		
		Arrays.sort(results);
		System.out.println("random numbers:");
		
		for(int r:results)
			System.out.print(r+" ");

	}

}
