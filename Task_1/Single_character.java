package Task_1;

import java.util.Scanner;

public class Single_character {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Single Character: ");
		char firstletter=scan.next().charAt(0);
		
		char nextLetter=(char)(firstletter+1);
		
		System.out.println("Enter a single character: "+firstletter);
		System.out.println("The next character after '" + firstletter + "' is: " + nextLetter);
		
	}
}
