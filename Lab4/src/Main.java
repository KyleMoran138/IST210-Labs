
public class Main {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		e1.setFname("Bob");
		e2.setFname("Susan");
		e1.setLname("Jones");
		e2.setLname("Baker");
		
		e1.setYearlySalary(34500);
		e2.setYearlySalary(37809);
		
		e1.sayThirdPersonSalary();
		e2.sayThirdPersonSalary();
		
		System.out.println("\n");
		
		e1.applyRaisePercent(0.10);
		e2.applyRaisePercent(0.10);
		
		e1.sayThirdPersonSalary();
		e2.sayThirdPersonSalary();
		
	}

}
