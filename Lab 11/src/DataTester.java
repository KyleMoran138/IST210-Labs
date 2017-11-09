
public class DataTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[100];
		arr[0] = 77; 			// insert 10 items
		arr[1] = 99;
		arr[2] = 44;
		arr[3] = 55;
		arr[4] = 22;
		arr[5] = 88;
		arr[6] = 11;
		arr[7] = 3;
		arr[8] = 66;
		arr[9] = 33;
		int nElems = 10; 			// now 10 items in array
		
		IntegerData arrayObj= new IntegerData(arr, nElems);
		System.out.format("\nDisplaying all members of the array\n");
		arrayObj.DisplayAll();
		
		System.out.format("\nDisplaying element at index 6 of the array\n");
		arrayObj.DisplayAt(6);
		
		System.out.format("\nFind 55 in the array\n");
		if (arrayObj.Find(55) != -1) {
			System.out.format("Number 55 was found at index %d of the array\n", arrayObj.Find(55));
		}
		else {
			System.out.format("Number 55 was NOT found.\n");
		}
				
		
		System.out.format("\nDelete 55 from the array\n");
		arrayObj.Delete(55);
			
		System.out.format("\nFind 55 in the array\n");
		if (arrayObj.Find(55) != -1) {
			System.out.format("Number 55 was found at index %d of the array\n", arrayObj.Find(55));
		}
		else {
			System.out.format("Number 55 was NOT found.\n");
		}

		System.out.format("\nDisplaying all members of the array\n");
		arrayObj.DisplayAll();

		System.out.format("\nSorting the array\n");
		arrayObj.bubbleSort();
		
		System.out.format("\nDisplaying all members of the array\n");
		arrayObj.DisplayAll();
		
		System.out.format("\nInset 49 into the array and then display array\n");
		arrayObj.insert(49);

		arrayObj.DisplayAll();

	}

}
