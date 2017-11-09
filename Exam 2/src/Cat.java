
public class Cat extends Pet {

	public Cat(int w, String name, double Price) {
		super(PET_TYPE.Feline, w, name, Price);
	}

	@Override
	public String sound() {
		return "Meow";
	}

}
