package kyle;
import java.util.Arrays;


public class DataArray {
	public  Person[] arr;
	private int nElms;
	
	public DataArray(int maxSize){
		this.arr = new Person[maxSize];
	}
	
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

	public void BubbleSort(){
		int inner, outer;
		Person t;
		for(outer = arr.length -1; outer > 0 ; outer--){
			for(inner = 0; inner < outer; inner++){
				if(arr[inner].compareTo(arr[inner +1]) > 0){
					t = arr[inner];
					arr[inner] = arr[inner + 1];
					arr[inner + 1] = t;
				}
			}
		}
	}
}
