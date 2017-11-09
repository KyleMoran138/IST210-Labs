
public class StudentGrades {
	public static int[][] StudentGrades = new int[5][3];
	
	public static void runProgram(){
		setGrades();
		displayGrades();
	}
	
	public static void setGrades(){
		StudentGrades[0] = new int[]{100, 90, 85};
		StudentGrades[1] = new int[]{70, 30, 65};
		StudentGrades[2] = new int[]{85, 75, 85};
		StudentGrades[3] = new int[]{92, 95, 87};
		StudentGrades[4] = new int[]{82, 81, 85};
	}
	
	public static void displayGrades(){
		for(int sId = 0; sId < StudentGrades.length; sId++){
			System.out.print("Student" + (sId+1) + " grades: ");
			for(int Grade : StudentGrades[sId]){
				if(Grade > 99){
					System.out.print(Grade + " ");
				}else{
					System.out.print(Grade + "  ");
				}
				
			}
			System.out.println();
		}
	}
	
}
