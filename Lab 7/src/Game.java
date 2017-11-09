import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;


public class Game {
	int balance = 20000;
	boolean runLoop = true;
	boolean hasLooped = false;
	STATUS currentStatus = STATUS.STOPED;
	int wager = 0;
	ROLL lastRollSum;
	int[] lastRoll;
	Scanner in;

	Game(){
		System.out.println("Game has started.");
		in = new Scanner(System.in);
	}

	public enum ROLL{
		ONE,
		SNAKE_EYES,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		ELEVEN,
		BOX_CARS
	}

	public enum STATUS{
		WIN, LOOSE, QUIT, RUNNING, STOPED;
	}

	public void endGame(STATUS s){
		runLoop = false;

		if(s == STATUS.WIN){
			balance = balance + wager;
			System.out.println("Player wins, balance is: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(balance));
		}else if(s == STATUS.LOOSE){
			System.out.println("Player loses.... \n \n \n Sorry you busted. Come back soon...");
		}else if(s == STATUS.QUIT){
			System.out.println("Thanks for playing.");
		}else if(s == STATUS.RUNNING){
			runLoop = true;
		};
	}

	public boolean startGame(){
		currentStatus = STATUS.RUNNING;
		String q = "Would you like to play a game of craps? [Y|N]: ";
		if(hasLooped){
			q = "Would you like to play another game of craps? [Y|N]: ";
		}
		System.out.print(q);
		String wantsToPlay = in.next();
		if(wantsToPlay.equalsIgnoreCase("y")){
			gameLoop();
			return true;
		}else if(wantsToPlay.equalsIgnoreCase("n")){
			endGame(STATUS.QUIT);
			return false;
		}else{
			runLoop = false;
			return false;
		}



	}

	public void gameLoop(){

		System.out.print("Enter a wager less than your balance or -1 to quit. Your balance is " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(balance) + ": ");
		wager = in.nextInt();
		if(wager > balance || wager < 0){
			endGame(STATUS.QUIT);
		}

		while(runLoop){
			if(hasLooped) System.out.println("Player goal: " + lastRollSum);

			doRoll();

			checkWinLoose(lastRollSum);

			endGame(currentStatus);

			if(!hasLooped) hasLooped = true;
		}



	}

	public int rollNumber(){
		return (int) Math.ceil(Math.random() * 6);
	}

	public int[] doRoll(){
		int[] x = {rollNumber(), rollNumber()};
		System.out.println("Player rolled: " + (x[0]+x[1]) + ":   " + x[0] + ", " +x[1]);
		switch (x[1]+x[0]) {
			case 1:
			lastRollSum = ROLL.ONE;
			break;
			case 2:
			lastRollSum = ROLL.BOX_CARS;
			break;
			case 3:
			lastRollSum = ROLL.THREE;
			break;
			case 4:
			lastRollSum = ROLL.FOUR;
			break;
			case 5:
			lastRollSum = ROLL.FIVE;
			break;
			case 6:
			lastRollSum = ROLL.SIX;
			break;
			case 7:
			lastRollSum = ROLL.SEVEN;
			break;
			case 8:
			lastRollSum = ROLL.EIGHT;
			break;
			case 9:
			lastRollSum = ROLL.NINE;
			break;
			case 10:
			lastRollSum = ROLL.TEN;
			break;
			case 11:
			lastRollSum = ROLL.ELEVEN;
			break;
			case 12:
			lastRollSum = ROLL.BOX_CARS;
			break;

		default:
			break;
		}
		return x;
	}


	public void checkWinLoose(ROLL x){
		if(!hasLooped){
			switch (x) {
			case SEVEN:
			case ELEVEN:
				currentStatus = STATUS.WIN;
				break;
			case SNAKE_EYES:
			case THREE:
			case BOX_CARS:
				currentStatus = STATUS.LOOSE;
				break;
			default:
				break;
			}
		}else{
			if(x == ROLL.SEVEN){
				currentStatus = STATUS.LOOSE;
			}
			if(x == lastRollSum){
				currentStatus = STATUS.WIN;
			}
			return;
		}

	}

}
