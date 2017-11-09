package kyle;
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
			cli.setupCommand("1", Main.class.getMethod("tryToFind", String[].class));
			cli.setupCommand("2", Main.class.getMethod("displayAll", String[].class));
			cli.setupCommand("3", Main.class.getMethod("displayAllCount", String[].class));
			cli.setupCommand("4", Main.class.getMethod("tryToCreate", String[].class));
			cli.setupCommand("5", Main.class.getMethod("tryToDelete", String[].class));
			cli.setupCommand("6", Main.class.getMethod("sortArray", String[].class));
			cli.setupCommand("7", Main.class.getMethod("deleteAll", String[].class));
			cli.setupCommand("8", Main.class.getMethod("populateArray", String[].class));
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
	
	public static Person tryToFind(String[] args){
		if(args.length <= 1){
			Scanner s = new Scanner(System.in);
			System.out.print("Enter last name to search: ");
			args = Arrays.copyOf(args, args.length + 1);
			args[1] = s.nextLine();
		}
		Person p = x.Find(args[1]);
		if(p == null){
			System.out.println("Can't find '" + args[1]+"'\n");
		}else{
			System.out.print("Found \t");
			p.displayPerson();
			System.out.println();
			return p;
		}
		return null;
	}

	public static void tryToDelete(String[] args){
		if(args.length <= 1){
			Scanner s = new Scanner(System.in);
			System.out.print("Enter last name to delete: ");
			args = Arrays.copyOf(args, args.length + 1);
			args[1] = s.nextLine();
		}
		if(x.DeletePerson(args[1])){
			System.out.println("Successfully deleted '" + args[1] + "'");
		}else{
			System.out.println("Not found. Could not delete '" + args[1] +"'\n");
		}
	}
	
	public static void tryToCreate(String[] args){
		String f,l;
		int a;
		Scanner i = new Scanner(System.in);
		System.out.print("Insert: Please enter the first name: ");
		f = i.next();
		System.out.print("Insert: Please enter the last name: ");
		l = i.next();
		System.out.print("Insert: Please enter the age: ");
		a = Integer.parseInt(i.next());
		
		x.InsertPerson(l, f, a);
		System.out.format("Person %s %s %d entered sucessfully \n\n", f, l, a);
		
		
	}

	public static void populateArray(String[] args){
		x.InsertPerson("Evans", "Patty", 24);
		x.InsertPerson("Smith", "Lorraine", 37);
		x.InsertPerson("Yee", "Tom", 43);
		x.InsertPerson("Adams", "Henry", 63);
		x.InsertPerson("Hashimoto", "Sato", 21);
		x.InsertPerson("Stimson", "Henry", 29);
		x.InsertPerson("Velasquez", "Jose", 72);
		x.InsertPerson("Lamarque", "Henry", 54);
		x.InsertPerson("Vang", "Minh", 22);
		x.InsertPerson("Creswell", "Lucinda", 18);
	}

	public static void listHelp(String[] args){
		System.out.println("1.\tFind a person by last name");
		System.out.println("2.\tDisplay all persons");
		System.out.println("3.\tDisplay count of persons in the directory");
		System.out.println("4.\tInsert a person");
		System.out.println("5.\tDelete a person");
		System.out.println("6.\tSort persons and update the person directory");
		System.out.println("7.\tDelete all persons from the directory");
		System.out.println("8.\tRe-populate the directory");
		System.out.println("9.\tQuit");
		System.out.println("10.\tDisplay help");
		System.out.println("-------------");
		System.out.println("Enter [1-10]");
	}

	public static void displayAll(String[] args){
		x.DisplayAllPersons();
	}

	public static void displayAllCount(String[] args){
		System.out.println(x.arr.length);
	}

	public static void quitCli(String[] args){
		cli.quit();
	}

	public static void sortArray(String[] args){
		x.BubbleSort();
	}

	public static void deleteAll(String[] args){
		x.deleteAllPersons();
	}

}
