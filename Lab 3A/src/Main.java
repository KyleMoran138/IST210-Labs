import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a five digit integer: ");
		String input = s.next();
		System.out.print("Digits in " + input + " are");
		for(int i = 0; i < 5; i++){
			System.out.print(" " + input.toCharArray()[i] + "  ");
		}
		s.close();
		
	}

}
