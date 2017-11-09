import java.util.Arrays;


public class DataArray {
	public  Person[] arr;
	private int nElms;
	
	public DataArray(int maxSize){
		this.arr = new Person[maxSize];
	}
	
	//Try to find person. Null if not found and Person if found
	public Person Find(String searchName){
		for(Person p : arr){
			if(p.LastName.equalsIgnoreCase(searchName)){
				return p;
			};
		}
		return null;
	}
	
	public Person Find(Person otherPerson){
		for(Person p : arr){
			if(p.equals(otherPerson)) return p;
		}
		return null;
	}
	
	//Add person. Expand array if last value set and set last if null
	public void InsertPerson(String last, String first, int age){
		if(arr[arr.length-1] == null){
			for(int i = 0; i < arr.length; i++){
				if(arr[i] == null){
					arr[i] = new Person(last, first, age);
					break;
				}
			}
		}else{
			int i = arr.length;
			arr = Arrays.copyOf(arr, i+1);
			InsertPerson(last, first, age);
		}
	}
	
	//Test if person exists and then delete if true
	public boolean DeletePerson(String searchName){
		if(Find(searchName) == null){
			return false;
		}else{
			for(int i = 0; i < arr.length; i++){
				if(arr[i].LastName.equalsIgnoreCase(searchName)){
					int og = arr.length;
					arr[i] = arr[og-1];
					arr = Arrays.copyOf(arr, og-1);
					break;
				}
			}

			
			return true;
		}
	}
	
	//Loop through all persons and display them
	public void DisplayAllPersons(){
		int i = 1;
		for(Person p : arr){
			if(p == null) break;
			System.out.print(i+")");
			p.displayPerson();
			i++;
		}
		System.out.println();
	}


	
}
