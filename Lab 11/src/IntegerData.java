import java.util.Arrays;


public class IntegerData {
	private int[] arr;
	private int iNumElements; 	//# of elements in the array, not the size of the array.

	//Constructor. Initializes both instance variables. Does not
	// create a new array.
	public IntegerData(int[] arr, int iNumElements){
		this.arr = arr;
		this.iNumElements = iNumElements;
	}

	// Displays the ith element
	public void DisplayAt(int i){
		System.out.println("Value at index " + i + " is: " + this.arr[i]);
	}

	// Display all elements in the array that have a value
	public void DisplayAll(){
		for(int i = 0; i < this.arr.length; i++){
			if(this.arr[i] != 0){
				System.out.print(" " + this.arr[i]);
			}
		}
	}

	// Key - value to search in the array
	// return value - index where key was found
	public int Find(int key){
		for(int i = 0; i < this.arr.length; i++){
			if(this.arr[i] == key){
				return i;
			}
		}
		return -1;
	}
	
	// delete 'key' from the array. 
	// which means that you must move up rest of the elements.
	public void Delete(int key){
		for(int i = 0; i < this.arr.length; i++){
			if(this.arr[i] == key){
				int[] copy = new int[this.arr.length-1];
	            System.arraycopy(this.arr, 0, copy, 0, i);
	            System.arraycopy(this.arr, i+1, copy, i, this.arr.length-i-1);
	            this.arr = copy;
			}
		}
		
	}


	// sort the array using bubble sort
	public void bubbleSort(){
		int out, in;
		int temp;
		for (out = iNumElements - 1; out > 0; out--){
			for (in = 0; in < out; in++){
				if (arr[in] > arr[in + 1]) {
					temp = arr[in];
					arr[in] = arr[in + 1];
					arr[in + 1] = temp;
				}
			}
		}
	}

	// insert an element in the array.
	public void insert(int n){
		this.arr = Arrays.copyOf(this.arr, this.arr.length);
		this.arr[this.arr.length-1] = n;
	}
	
	
}
