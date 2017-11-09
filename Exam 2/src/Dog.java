
public class Dog extends Pet {
	private String AKC;
	
	public Dog(int w, String name, double Price, String AKC) {
		super(PET_TYPE.Canine, w, name, Price);
		this.setAKC(AKC);
	}
	public Dog(int w, String name, double Price) {
		super(PET_TYPE.Canine, w, name, Price);
		this.setAKC("Mutt");
	}

	@Override
	public String sound() {
		return "Woof, Woof";
	}
	public String getAKC() {
		return AKC;
	}
	public void setAKC(String aKC) {
		AKC = aKC;
	}

}
