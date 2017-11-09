import java.util.Scanner;


public class Main {
	
	static boolean running = true;
	//[product][person] = salePrice;
	static int[][] personSales = new int[5][5];
	static int[] personTotals = new int[4];
	
	public static void main(String[] args) {
		gatherData();
		displayResults();
	}
	
	public static void gatherData(){
		Scanner in = new Scanner(System.in);
		String[] x;
		do{
			System.out.print("Enter sales ammount (negative to end): ");
			String a = in.next();
			x = a.split(",");
			if(Integer.parseInt(x[0]) ==  -1){
				running = false;
				continue;
			}
			if(x[0] != null && x[1] != null && x[2] != null){
				personSales[Integer.parseInt(x[0])-1][Integer.parseInt(x[1])-1] += Integer.parseInt(x[2]);
			}
			//Add value to person sales. 
		}while(running == true);
	}
	
	public static void displayResults(){
		System.out.println("Product \t Salesperson 1 \t Salesperson 2 \t Salesperson 3 \t Salesperson 4 \t Total");
		
		for(int i = 0; i < personSales.length; i++){
			for(int ii = 0; ii < personSales[i].length; ii++){
				personTotals[ii] += personSales[i][ii];
			}
		}
		
		for(int y = 0; y <= personSales.length; y++){
			if(y == personSales.length){
				System.out.print("Total\t\t");
				for(int iii = 0; iii < personTotals.length; iii++){
					System.out.print(" " + personTotals[iii] + "\t\t");
				}
			}else{
				System.out.print((y+1) + "\t\t");
				int itemTotal = 0;
				for(int x = 0; x <= personSales[y].length; x++){
					if(x == personSales[y].length){
						System.out.println(" "+itemTotal);
					}else{
						System.out.print(" " + personSales[y][x] + "\t\t");
						itemTotal += personSales[y][x];
					}
				}
			}
		}
	}

}
