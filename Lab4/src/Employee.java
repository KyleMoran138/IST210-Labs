import java.text.NumberFormat;
import java.util.Locale;


public class Employee {
	String fname = "";
	String lname = "";
	double monthlySalary = 0;
	
	public String setFname(String fname){
		this.fname = fname;
		return this.fname;
	}
	
	public String setLname(String lname){
		this.lname = lname;
		return this.lname;
	}
	
	public double setMonthlySalary(double salary){
		if(salary > 0){
			this.monthlySalary = salary;
		}
		return this.monthlySalary;
	}
	
	public double setYearlySalary(double salary){
		this.monthlySalary = salary / 12;
		return this.monthlySalary;
	}
	
	public void sayHello(){
		System.out.println("Hello! My name is " + this.fname + " " + this.lname);
	}
	
	public void sayThirdPersonSalary(){
		System.out.println(this.fname + " " + this.lname + ", Yearly Salary: " + NumberFormat.getCurrencyInstance(new Locale("en", "US"))
		        .format((this.monthlySalary * 12)));
	}
	
	public void applyRaisePercent(double raise){
		this.monthlySalary = this.monthlySalary + (this.monthlySalary * raise);
	}
	
}
