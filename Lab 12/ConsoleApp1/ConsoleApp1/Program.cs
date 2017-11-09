using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    public class IntegerData {

        //Two fields or instance variables. 
        private int[] arr;
        private int iNumElements;   //# of elements in the array, not the size of the array.


        public IntegerData(int[] arr, int iNumElements) {
            this.arr = arr;
            this.iNumElements = iNumElements;
        }

    // Displays the ith element
        public void DisplayAt(int i) {
            if(arr.Length > i-1){
                Console.WriteLine(arr[i]);
            };
        }

    // Display all elements in the array that have a value
        public void DisplayAll() {
            foreach(int i in arr){
                Console.WriteLine(i);
            }
        }

    // Key - value to search in the array
    // return value - index where key was found
        public int Find(int key) {
            for(int i = 0; i < arr.Length; i++){
                if(arr[i] == key){
                    return i;
                }
            }
            return -1;
        }

    // delete 'key' from the array. 
    // which means that you must move up rest of the elements.
        public void Delete(int key) {
            if(Find(key) != -1){

            }
        }


    // sort the array using bubble sort
        public void bubbleSort() { }

    // insert an element in the array.
        public void insert(int n) { }
    }

}
