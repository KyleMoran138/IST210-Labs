
public abstract class Pet {
	

	private PET_TYPE type;
	private int weight;
	private String name;
	private double price;
	
	// Constructor function
	// Takes (Type, Weight, name)
	public Pet(PET_TYPE t, int w, String name, double Price){
		this.type = t;
		this.weight = w;
		this.name = name;
		this.price = Price;
	}
	
	// ===== ABSTRACT =====
	public abstract String sound();
	
	// ===== GET =====
	
	//Get the pets weight
	public int getWeight(){
		return this.weight;
	}
	
	//Get the pets name
	public String getName(){
		return this.name;
	}
	
	//Get the pets type
	public PET_TYPE getType(){
		return this.type;
	}
	
	//Get the pets price
	public double getPrice() {
		return price;
	}
	
	// ===== SET =====
	
	public boolean setWeight(int w){
		if(w > 0){
			this.weight = w;
			return true;
		}else{
			return false;
		}
	}
	
	//Set the pet price
	public void setPrice(double price) {
		this.price = price;
	}
	
	// ===== Tools =====
	
	public String toString(){
		return String.format("%-10s%-15s   weight: %3s, price: $%,.2f, makes sound: %s.", type, name, weight, price, sound());
	}



	
	
}

