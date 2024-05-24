package Task_1;

import java.util.Scanner;

public class Integers {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the first integer: ");
		int num1=scan.nextInt();
		System.out.println("Enter the Second integer: ");
		int num2=scan.nextInt();
		 int sum = num1 + num2;
	     int difference = num1 - num2;
	     int product = num1 * num2;
	     System.out.println("Sum of " + num1 + " and " + num2 + " is: " + sum);
	     System.out.println("Difference between " + num1 + " and " + num2 + " is: " + difference);
	     System.out.println("Product of " + num1 + " and " + num2 + " is: " + product);
}
}
