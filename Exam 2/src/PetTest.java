import java.util.ArrayList;
import java.util.Arrays;



public class PetTest {
	
	public static ArrayList<Pet> AlistPets = new ArrayList<Pet>(5);
	public static Pet[] APets = new Pet[5];
	
	public static void main(String[] args) {
		APets[0] = new Dog(55, "King", 1000, "aka1000");
		APets[1] = new Dog(25, "Princess", 2000, "aka1001");
		APets[2] = new Dog(25, "Spike", 25);
		APets[3] = new Cat(15, "Missy", 50);
		APets[4] = new Cat(5, "Mr Boogangle", 30);
		for(int i = 0; i < APets.length; i++){
			System.out.println(APets[i].toString());
		}
		
		AlistPets = new ArrayList<Pet>(Arrays.asList(APets));
		System.out.println("");
		for(Pet p : AlistPets){
			System.out.println(p.toString());
		}
		
	}
	
	public static void listPets(){
		
		System.out.println("");
	}

}
