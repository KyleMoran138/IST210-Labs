

public class Main {
	
	public static Pet pets[] = new Pet[4];
	
	public static void main(String[] args) {
		pets[0] = new Pet(Pet.TYPE.CAT, 5, "Misty");
		pets[1] = new Pet(Pet.TYPE.BIRD, 1, "Tony");
		pets[2] = new Pet(Pet.TYPE.DOG, 50, "Rufus");
		pets[3] = new Pet(Pet.TYPE.DOG, 20, "Sheba");
		
		listPets();
		
		/*pets[2].setName("Doggo");
		pets[2].setType(Pet.TYPE.CAT);
		pets[2].name = "Doggo";
		pets[2].type = Pet.TYPE.CAT;*/
		
		pets[2].setWeight(55);
		
		listPets();
		
		StudentGrades.runProgram();
		
	}
	
	public static void listPets(){
		for(Pet p : pets){
			System.out.println(p.toString());
		}
		System.out.println("");
	}

}
