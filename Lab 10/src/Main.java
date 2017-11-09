
public class Main {
	public static int[] totals;
	public static void main(String[] args) {
		totals = new int[12];
		roll36TTimes();
		System.out.println("SUM\tFrequency\tPercentage");
		for(int i = 1; i < totals.length; i++){
			float p = (float)(totals[i] * 100) / 36000000;
			System.out.println(i+1 + "  \t" + totals[i] + "  \t" + Math.floor(p * 100) / 100);
		}
	}
	
	public static void roll36TTimes(){
		int iterator = 0;
		for(;iterator < 36000000; iterator++){
			totals[((int) Math.ceil(Math.random() * 6) + (int) Math.ceil(Math.random() * 6)) - 1]++;
		}
	}

}
