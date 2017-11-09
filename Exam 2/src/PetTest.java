import java.util.ArrayList;
import java.util.Arrays;



public class PetTest {
	
	public static ArrayList<Pet> AlistPets = new ArrayList<Pet>(5);
	public static Pet[] APets = new Pet[5];
	
	public static void main(String[] args) {
		// Populate the array with Pets.
		APets[0] = new Dog(55, "King", 1000, "aka1000");
		APets[1] = new Dog(25, "Princess", 2000, "aka1001");
		APets[2] = new Dog(25, "Spike", 25);
		APets[3] = new Cat(15, "Missy", 50);
		APets[4] = new Cat(5, "Mr Boogangle", 30);
		
		// Iterate over the array and display the pet information.
		for(int i = 0; i < APets.length; i++){
			System.out.println(APets[i].toString());
		}
		
		// Copy the array into an array list.
		AlistPets = new ArrayList<Pet>(Arrays.asList(APets));
		
		// Add a empty line to the console. 
		System.out.println("");
		
		// Iterate over the array list and display the 
		for(Pet p : AlistPets){
			
			// If the pet type is a dog then display it's AKC else just display Pet.toString()
			if(p.getType() == PET_TYPE.Canine){
				
				// This is the same as the toString() in Pet.java but this one includes p.getAKC()
				System.out.println(String.format("%-10s%-15s   weight: %3s, price: $%,.2f, makes sound: %s, Reg: %s.", p.getType(),
						p.getName(), p.getWeight(), p.getPrice(), p.sound(),((Dog) p).getAKC()));
			}else{
				System.out.println(p.toString());
			}
		}
		
	}
	
}
