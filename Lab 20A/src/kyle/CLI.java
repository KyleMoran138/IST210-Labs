package kyle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;

public class CLI {
	static HashMap<String, Method> commands;
	boolean isRunning = true;
	
	public CLI(){
		commands = new HashMap<String, Method>();	
	}
	
	public void run(){
		Scanner input = new Scanner(System.in);
		String lastInput;
		String[] args = {};
		boolean firstLoop = true;
		while(isRunning){
			if(firstLoop){
				firstLoop = false;
			}
			System.out.print("#");
			lastInput = input.nextLine();
			args = lastInput.split(" ");
			if(!processCommand(args[0], args)){
				System.out.println("Command dosen't exist!");
			};
		}
		input.close();
	}

	public void quit(){
		System.out.println("Goodbye.");
		isRunning = false;
	}
	
	public static String queryUser(String query){
		Scanner s = new Scanner(System.in);
		String returnValue = "";
		try{
			System.out.print(query);
			returnValue = s.next();
		}catch(Exception e){
			System.err.println("CLI class error!!!\nIssue in user query");
		}
		return returnValue;
		
	}
	
	private boolean processCommand(String lastCommand, String[] args) {
		lastCommand = lastCommand.toUpperCase();
		if(commands.containsKey(lastCommand)){
			try {
				commands.get(lastCommand).invoke(Main.class, new Object[]{args});
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return true;
		}else{
			return false;
		}
	}

	public void setupCommand(String name, Method method){
		try {
			commands.put(name, method);
		} catch (SecurityException e) {
			System.err.println("System failed to populate command hashmap. SECURITY ISSUE!");
			System.exit(0);
		}
	}
}
