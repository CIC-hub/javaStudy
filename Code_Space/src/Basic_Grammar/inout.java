package Basic_Grammar;

import java.util.*;
import java.io.Console;
import java.io.Console.*;

public class inout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//Scanner input
		Scanner in = new Scanner(System.in);
		
		System.out.println("What's your name?");		
		String name = in.nextLine();
		
		System.out.println("What's your age?");		
		int age = in.nextInt();
		
		System.out.println(name+" is "+age+" years old");
	
	//Console input
		Console cons = System.console();
		
		String username = cons.readLine("Username:");
		char password[]	=	cons.readPassword("Password:");
		System.out.println("Username: "+username);
		System.out.println("Password: "+password);	
	
	}
}
