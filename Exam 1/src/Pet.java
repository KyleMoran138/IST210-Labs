
public class Pet {
	
	public static enum TYPE{
		CAT, DOG, BIRD	
	};
	
	private TYPE type;
	private int weight;
	private String name;
	
	// Constructor function
	// Takes (Type, Weight, name)
	public Pet(TYPE t, int w, String name){
		this.type = t;
		this.weight = w;
		this.name = name;
	}
	
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
	public TYPE getType(){
		return this.type;
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
	
	// ===== Tools =====
	
	public String toString(){
		String x = "";
		x += this.type.toString() + " \t ";
		x += this.name + " \t ";
		x += this.weight + " lbs.";
		return x;
	}
	
}

