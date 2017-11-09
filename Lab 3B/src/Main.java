import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		System.out.print("Please enter pennies: ");
		int input = i.nextInt(), original = input;
		System.out.println("Original ammount: " + original);
		System.out.println("Number of Dollars:" + input / (100));
		input = input % (100);
		System.out.println("Number of Quarters:" + input / (25));
		input = input % (25);
		System.out.println("Number of dimes:" + input / (10));
		input = input % (10);
		System.out.println("Number of Nickels:" + input / (5));
		input = input % (5);
		System.out.println("Number of Pennies:" + input / (1));
	}

}
