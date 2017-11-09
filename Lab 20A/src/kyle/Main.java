package kyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static DataArray x = new DataArray(0);
	public static CLI cli;
	
	public static void main(String[] args){
		cli = new CLI();
		setupCommands(cli);
		listHelp(new String[]{});
		cli.run();
	}

	public static void setupCommands(CLI cli){
		try {
			cli.setupCommand("1", Main.class.getMethod("displayCount", String[].class));
			cli.setupCommand("2", Main.class.getMethod("findByFirstName", String[].class));
			cli.setupCommand("3", Main.class.getMethod("findByLastName", String[]. class));
			cli.setupCommand("4", Main.class.getMethod("deleteByLastName", String[]. class));
			cli.setupCommand("5", Main.class.getMethod("deleteSinglePerson", String[]. class));
			
			cli.setupCommand("9", Main.class.getMethod("quitCli", String[].class));
			cli.setupCommand("10", Main.class.getMethod("listHelp", String[].class));
		} catch (NoSuchMethodException e) {
			System.out.println("Failed to add commands! NoSuchMethod!");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("Failed to add commands! SecurityException!");
			e.printStackTrace();
		}
	}
	
	//Commands
	
	public static void displayCount(String[] args){
		System.out.println("Number of persons in list: " + x.getArrayList().size());
	}
	
	public static void findByFirstName(String[] args){
		String firstName = "";
		if(args.length == 1){
			firstName = CLI.queryUser("Enter first name to search:");
		}else{
			firstName = args[1];
		}
		System.out.println("Listing all persons with first name '" + firstName + "'");
		ArrayList<Person> pal = x.findByFirstName(firstName);
		if(pal != null){
			System.out.println("Found " + pal.size() + " persons with the first name '" + firstName + "'");
			for(Person p : pal){
				p.displayPerson();
			}
		}else{
			System.out.println("There were no person(s) found with the first name '" + firstName + "'");
		}
	}

	public static void findByLastName(String[] args){
		String lastName = "";
		if(args.length == 1){
			lastName = CLI.queryUser("Enter last name to search:");
		}else{
			lastName = args[1];
		}
		System.out.println("Listing all persons with last name '" + lastName + "'");
		ArrayList<Person> pal = x.findByLastName(lastName);
		if(pal != null){
			System.out.println("Found " + pal.size() + " persons with the last name '" + lastName + "'");
			for(Person p : pal){
				p.displayPerson();
			}
		}else{
			System.out.println("There were no person(s) found with the last name '" + lastName + "'");
		}
	}
	
	public static void deleteByLastName(String[] args){
		String lastName = "";
		if(args.length == 1){
			lastName = CLI.queryUser("Enter last name to delete:");
		}else{
			lastName = args[1];
		}
		ArrayList<Person> pal = x.findByLastName(lastName);
		if(pal != null){
			System.out.println("Deleting all persons with the last name '" + lastName + "'!");
			for(Person p : pal){
				System.out.println("Deleting " + p.toString());
				x.DeletePerson(p);
			}
		}else{
			System.out.println("There were no person(s) found with the last name '" + lastName + "'");
		}
	}
	
	public static void deleteSinglePerson(String[] args){
		String lastName = "", firstName = "";
		if(args.length == 1){
			lastName = CLI.queryUser("Enter last name to delete:");
			firstName = CLI.queryUser("Enter first name to delete:");
		}else if(args.length == 2){
			lastName = args[1];
			firstName = CLI.queryUser("Enter first name to delete:");
		}else if(args.length == 3){
			lastName = args[1];
			firstName = args[2];
		}
		if(x.deletePerson(firstName, lastName)){
			System.out.println("Deleted " + firstName + " " + lastName);
		}else{
			System.out.println("Couldn't find " + firstName + " " + lastName);
		}
	}
	
	public static void listHelp(String[] args){
		System.out.println("1.\tFind number of persons in list");
		System.out.println("2.\tFind a person by first name");
		System.out.println("3.\tFind a person by last name");
		System.out.println("4.\tDelete a person by last name");
		System.out.println("5.\tDelete a person by last & first name");

		System.out.println("9.\tQuit");
		System.out.println("10.\tDisplay help");
		System.out.println("-------------");
		System.out.println("Enter [1-10]");
	}

	public static void quitCli(String[] args){
		cli.quit();
	}

}
