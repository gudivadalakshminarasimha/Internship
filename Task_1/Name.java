package Task_1;

import java.util.Scanner;

public class Name {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter your name: ");
		String name=scan.next();
		System.out.println("Enter your name:"+name);
		System.out.println("Hello"+","+name);
	}
}
