
public class Main {

	public static void main(String[] args) {
		Invoice x = new Invoice("1234", "Hammer", 2, 14.95);
		
		System.out.println("Original Invoice");
		x.displayInformation();
		
		x.setPartNumber("001234");
		x.setDesc("Yellow Hammer");
		x.setQuanity(3);
		x.setCost(19.49);
		
		System.out.println("Updated invoice information");
		x.displayInformation();
		
		x.setPartNumber("001234");
		x.setDesc("Yellow Hammer");
		x.setQuanity(-3);
		x.setCost(-19.49);

		System.out.println("With negative quantity and negative price");
		System.out.println("Updated invoice information");
		x.displayInformation();
		
		
		
	}

}
