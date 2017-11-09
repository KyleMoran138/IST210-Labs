import java.util.Scanner;


public class Main {
	static int tries = 0;
	static boolean wannaPlay;
	static boolean isGuessing = true;
	static int number;
	
	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		do{
			getWannaPlay(i);
			while(isGuessing){
				checkGuess(getGuess(i));
			}			
			
		}while(wannaPlay);
	}
	
	public static void getWannaPlay(Scanner i){
		System.out.print("Wanna play a game?[Y|N]: ");
		String ans = i.next();
		if(ans.equalsIgnoreCase("Y")){
			wannaPlay = true;
			isGuessing = true;
			number = (int) Math.ceil(Math.random() * 1000);
			tries = 0;
		}else if(ans.equalsIgnoreCase("N")){
			wannaPlay = false;
			isGuessing = false;
		}else{
			System.out.println("Invalid response, Goodbye.");
			wannaPlay = false;
			isGuessing = false;
		}
	}
	
	public static int getGuess(Scanner i){
		System.out.print("Guess number: ");
		tries++;
		return Integer.parseInt(i.next());
	}

	public static void checkGuess(int guess){
		if(guess == number && tries < 10){
			System.out.println("Congratulations!!! You won the game in " + tries + " tries. You did very well.");
			isGuessing = false;
		}else if(guess == number && tries > 10){
			System.out.println("Congratulations!!! You won the game in " + tries + " tries. You did very well.");
			isGuessing = false;
		}else if(guess > number){
			System.out.println("Too high!");
		}else if(guess < number){
			System.out.println("Too low.");
		}else if(guess == -1){
			isGuessing = false;
			wannaPlay = false;
			System.out.println("Goodbye...");
		}
	}
	
}
