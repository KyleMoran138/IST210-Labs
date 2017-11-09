
public class Person {
	
	public String LastName;
	public String FirstName;
	public int Age;
	//Constructor
	public Person(String last, String first, int a){
		LastName = last;
		FirstName = first;
		Age = a;
	}

	//Constructor	
	public Person(){
		this("", "", 0);
	}
	
	//Display person fname lname and age
	public void displayPerson(){
		System.out.format("%10s %1s\t Age: %d\n", FirstName, LastName, Age);
	}

	public int compareTo(Person person) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
