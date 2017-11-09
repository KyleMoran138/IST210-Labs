import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter radius: ");
		int r = in.nextInt();

		System.out.println("Radius: " + r);
		System.out.println("Diameter: " + r*2);
		System.out.println("Circumference: " + (double) Math.round(((Math.PI * 2) * r)* 100.00) / 100.00);
		System.out.println("Area: " + (double) Math.round(Math.PI * Math.pow(r, 2)*100.00 )/ 100.00);
	}

}
