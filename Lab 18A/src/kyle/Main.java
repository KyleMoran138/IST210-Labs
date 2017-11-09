package kyle;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args){
		//Create array
		DataArray x = new DataArray(10);
		
		//Populate array
		x.InsertPerson("Evans", "Patty", 24);
		x.InsertPerson("Smith", "Lorraine", 37);
		x.InsertPerson("Yee", "Tom", 43);
		x.InsertPerson("Adams", "Henry", 63);
		x.InsertPerson("Hashimoto", "Sato", 21);
		x.InsertPerson("Stimson", "Henry", 29);
		x.InsertPerson("Velasquez", "Jose", 72);
		x.InsertPerson("Lamarque", "Henry", 54);
		x.InsertPerson("Vang", "Minh", 22);
		x.InsertPerson("Creswell", "Lucinda", 18);
				
		//Display all Persons
		x.DisplayAllPersons();
		
		//Try find
		tryToFind(x, "Stimson");
		
		//Try bad find
		tryToFind(x, "Jacobson");
		
		tryToDelete(x, "Smith");
		tryToDelete(x, "Yee");
		tryToDelete(x, "Thompson");
		
		x.DisplayAllPersons();
		
		tryToCreate(x);
		
		x.BubbleSort();
		
		x.DisplayAllPersons();
		
	}
	
	public static Person tryToFind(DataArray x, String sn){
		Person p = x.Find(sn);
		if(p == null){
			System.out.println("Can't find '" + sn+"'\n");
		}else{
			System.out.print("Found \t");
			p.displayPerson();
			System.out.println();
			return p;
		}
		return null;
	}

	public static void tryToDelete(DataArray x, String sn){
		if(x.DeletePerson(sn)){
			System.out.println("Successfully deleted '" + sn + "'");
		}else{
			System.out.println("Not found. Could not delete '" + sn +"'\n");
		}
		
	}
	
	public static void tryToCreate(DataArray x){
		String f,l;
		int a;
		Scanner i = new Scanner(System.in);
		System.out.print("Insert: Please enter the first name: ");
		f = i.next();
		System.out.print("Insert: Please enter the first name: ");
		l = i.next();
		System.out.print("Insert: Please enter the age: ");
		a = Integer.parseInt(i.next());
		
		x.InsertPerson(l, f, a);
		System.out.format("Person %s %s %d entered sucessfully \n\n", f, l, a);
		
		
	}
	
}
