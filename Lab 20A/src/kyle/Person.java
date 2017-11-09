package kyle;

public class Person implements Comparable <Person>{
	
	public String LastName;
	public String FirstName;
	public int Age;
	private String address;

	public Person(String last, String first, int a, String address){
		LastName = last;
		FirstName = first;
		Age = a;
		this.address = address;
	}

	public Person(String last, String first, String address){
		LastName = last;
		FirstName = first;
		Age = -1;
		this.address = address;
	}
	
	public Person(String last, String first, int a){
		LastName = last;
		FirstName = first;
		Age = a;
	}
	
	public Person(){
		this("", "", 0);
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void displayPerson(){
		if(Age != -1){
			System.out.format("%15s %3s\t Age: %d\n", FirstName, LastName, Age);
		}else{
			System.out.format("%15s,%3s\t %s\n", LastName, FirstName, address);
		}
		
	}

	public int compareTo(Person other) {
		if(this.LastName.equals(other)){
			if(this.FirstName.equals(other)){
				return new Integer(this.Age).compareTo(other.Age);
			}else{
				return this.FirstName.compareTo(other.FirstName);
			}
		}
		return this.LastName.compareTo(other.LastName);
	}

	public Boolean Equals(Object obj){
		if(this == obj) return true;
		if(obj == null || this.getClass() != obj.getClass()) return false;
		
		Person other = (Person)obj;
		
		if(this.getClass() == other.getClass()) return true;
		
		if(this.Age != other.Age){
			return false;
		}
		
		if(this.FirstName == null && other.FirstName != null){
			return false;
		}else if(!this.FirstName.equals(other.FirstName)) return false;
		
		if(this.LastName == null && other.LastName != null){
			return false;
		}else if(!this.LastName.equals(other.LastName)) return false;
		
		return false;
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = result * prime + this.Age;
		result = result * prime + ((this.FirstName == null) ? 0 : this.FirstName.hashCode());
		result = result * prime + ((this.LastName == null) ? 0 : this.LastName.hashCode());
		return result;
	}
 
	@Override
	public String toString(){
		if(Age != -1){
			return String.format("%s $s Age: %s", FirstName, LastName, Age);
		}else{
			return String.format("%s,%s %s", FirstName, LastName, address);
		}
		
	}
	
}
