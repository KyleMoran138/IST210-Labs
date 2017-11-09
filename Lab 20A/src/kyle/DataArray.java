package kyle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class DataArray {
	private ArrayList<Person> arr;
	private static final String filePath = "Z:\\IT\\IST210\\Yusuf\\Lab Assignments\\Person2000Address.csv"; 
	
	public DataArray(int maxSize){
		this.arr = new ArrayList<Person>(maxSize);
		loadData(filePath);
	}
	
	private void loadData(String filePath){
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = br.readLine()) != null){
				String[] personString  = line.split(",");
				this.InsertPerson(new Person(personString[1], personString[0],(String)( personString[2] + " " + personString[3] + " " + personString[4] + personString[5])));
			}
			
			
		}catch(Exception e){
			System.err.println("Failed to read the file '" + filePath +"' plaease contact someone");
			
		}finally{
			if(br != null){
				try{
					br.close();
				}catch(Exception e ){
					System.err.println("Failed to close the file, shit's fucked.");
				}
			}
		}
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
		if(arr.size() >=1){
			for(Person p : arr){
				if(p.equals(otherPerson)) return p;
			}
		}
		return null;
	}
	
	public ArrayList<Person> Find(String firstName, String lastName){
		ArrayList<Person> returnValue = new ArrayList<Person>();
		for(Person p : arr){
			if(p.FirstName.equalsIgnoreCase(firstName) && p.LastName.equalsIgnoreCase(lastName)){
				returnValue.add(p);
			}
		}
		return returnValue;
	}
	
	public void InsertPerson(String last, String first, int age){
		arr.add(new Person(last, first, age));
	}
	
	public void InsertPerson(Person p){
		arr.add(p);
	}
	
	public boolean DeletePerson(String searchName){
		if(Find(searchName) == null){
			return false;
		}else{
			for(int i = 0; i < arr.size(); i++){
				if(arr.get(i).LastName.equalsIgnoreCase(searchName)){
					arr.remove(i);
				}
			}

			
			return true;
		}
	}
	
	public boolean DeletePerson(Person p){
		return arr.remove(p);
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
		for(outer = arr.size() -1; outer > 0 ; outer--){
			for(inner = 0; inner < outer; inner++){
				if(arr.get(inner).compareTo(arr.get(inner +1)) > 0){
					t = arr.get(inner);
					arr.set(inner, arr.get(inner + 1));
					arr.set(inner + 1, t);
				}
			}
		}
	}

	public void deleteAllPersons() {
		arr = new ArrayList<Person>();	
	}

	public ArrayList<Person> getArrayList(){
		return arr;
	}

	public ArrayList<Person> findByFirstName(String name){
		ArrayList<Person> returnValue = new ArrayList<Person>();
		for(Person p : this.arr){
			if(p.FirstName.compareTo(name) == 0){
				returnValue.add(p);
			}
		}
		if(returnValue.size() == 0) return null;
		return returnValue;
	}
	
	public ArrayList<Person> findByLastName(String name){
		ArrayList<Person> returnValue = new ArrayList<Person>();
		for(Person p : this.arr){
			if(p.LastName.compareTo(name) == 0){
				returnValue.add(p);
			}
		}
		if(returnValue.size() == 0) return null;
		return returnValue;
	}

	
	public boolean deletePerson(String firstName, String lastName) {
		ArrayList<Person> pToD = Find(firstName, lastName);
		if(pToD == null || pToD.size() == 0) return false;
		for(Person p : pToD){
			DeletePerson(p);
		}
		return true;
	}




}
