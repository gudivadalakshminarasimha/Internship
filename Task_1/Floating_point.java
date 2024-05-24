package Task_1;

import java.util.Scanner;

public class Floating_point {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter the Float Number: ");
		float num1=scan.nextFloat();
		float result=num1*2;
		
		System.out.println("Enter a floating-point number:"+"+"+" "+num1);
		System.out.println(num1 + " multiplied by 2 is: " + result);
		
	}
}
