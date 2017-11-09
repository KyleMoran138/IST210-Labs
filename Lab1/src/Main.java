import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Byte a;
		Short b;
		int c;
		Long d;
		Float e;
		Double f;
		char g;
		String h;
		Boolean i;
		Object j;

		System.out.println("Enter a Byte: ");
		a = (Byte) in.nextByte();

		System.out.println("Enter a Short: ");
		b = (Short) in.nextShort();

		System.out.println("Enter a Int: ");
		c = (int) in.nextInt();

		System.out.println("Enter a Long: ");
		d = (Long) in.nextLong();

		System.out.println("Enter a Float: ");
		e = (Float) in.nextFloat();

		System.out.println("Enter a Double: ");
		f = (Double) in.nextDouble();

		System.out.println("Enter a Char: ");
		String aa = in.next();
		g = aa.charAt(0);

		System.out.println("Enter a String: ");
		h = (String) in.next();

		System.out.println("Enter a Boolean: ");
		i = (Boolean) in.nextBoolean();

		System.out.println("Enter a Object: ");
		j = (Object) in.next();


		System.out.println("a equals: " + a.toString());
		System.out.println("b equals: " + b.toString());
		System.out.println("c equals: " + c);
		System.out.println("d equals: " + d.toString());
		System.out.println("e equals: " + e.toString());
		System.out.println("f equals: " + f.toString());
		System.out.println("g equals: " + g);
		System.out.println("h equals: " + h.toString());
		System.out.println("i equals: " + i.toString());
		System.out.println("j equals: " + j.toString()); 


	}

}
