package Task_1;
import java.util.Scanner;

public class Opposite {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a boolean value (true/false): ");
	        boolean userInput = scanner.nextBoolean();
	        boolean opposite = !userInput;
	        System.out.println("The opposite of " + userInput + " is: " + opposite);
	    }
	

}
