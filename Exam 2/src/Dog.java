
public class Dog extends Pet {
	private String AKC;
	
	public Dog(int w, String name, double Price, String AKC) {
		super(PET_TYPE.Canine, w, name, Price);
		this.AKC = AKC;
	}
	public Dog(int w, String name, double Price) {
		super(PET_TYPE.Canine, w, name, Price);
		this.AKC = "Mutt";
	}

	@Override
	public String sound() {
		return "Woof, Woof";
	}
	
	@Override
	public String toString(){
		return String.format("%-10s%-15s   weight: %3s, price: $%,.2f, makes sound: %s, Reg: %s.", this.getType(), this.getName(), this.getWeight(), this.getPrice(), sound(), this.AKC);
	}

}
