
public class Main {

	public static void main(String[] args) {
		Time a = new Time();
		Time b = new Time(3,20,0);
		Time c = new Time(13,45);
		Time d = new Time(15);
		Time e = new Time(b);

		System.out.println("Universal time is " + a.toUniversalString());
		System.out.println("Standard time is " + a.toString() + "\n");

		System.out.println("Universal time is " + b.toUniversalString());
		System.out.println("Standard time is " + b.toString() + "\n");

		System.out.println("Universal time is " + c.toUniversalString());
		System.out.println("Standard time is " + c.toString() + "\n");

		System.out.println("Universal time is " + d.toUniversalString());
		System.out.println("Standard time is " + d.toString() + "\n");

		System.out.println("Universal time is " + e.toUniversalString());
		System.out.println("Standard time is " + e.toString() + "\n");

		b.setTime(13, 27, 6);
		System.out.println("Universal time is " + b.toUniversalString());
		System.out.println("Standard time is " + b.toString());


	}

}
