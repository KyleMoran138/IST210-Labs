import java.util.Arrays;
import java.util.Scanner;


public class Main {
	static int[] sales = new int[1];
	static int results = 10;
	static int interval = 100;
	static boolean running = true; 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = 0; 
		
		do{
			System.out.print("Enter sales ammount (negative to end): ");
			x = in.nextInt();
			if(x < 0){
				System.out.println("Less than 0");
				running = false;
				continue;
			}
			addToArray((int)(200 + (x * 0.09)));
		}while(running == true);
		
		System.out.println("Range \t \t Number");
		
		for(int i = 2; i <= results; i++){
			int z = 0;
			int low = i * interval;
			int high = ((i+1) * interval) -1;
			for(int y : sales){
				if(y > low && y <= high){
					z++;
				}
			}
			if(i == results){
				z = 0;
				for(int y : sales){
					if(y > high-99){
						z++;
					}
				}
				System.out.println(high-99 + " and over \t" + z);

			}else{
				System.out.println(low + "-" + high + ": \t" + z);
			}
		}
		
	}
	
	public static void addToArray(int toAdd){
		sales = Arrays.copyOf(sales, sales.length + 1);
		sales[sales.length - 1] = toAdd;
		
	}
	
	

}
