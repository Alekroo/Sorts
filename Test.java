import java.util.Random;
import java.util.Arrays;


//1.Creates arrays with different input types.
//2.Uses different sorting algorithms to sort those arrays.
//3.Prints out the newly sorted arrays.

public class Test 
{

	public static void main(String[] args) 
	{

		Sorts test = new Sorts();

		Random random = new Random();
		int antallE = 10;
		//Array with random numbers from 0 - 9.
		int[] randomArr = new int[antallE];

		for (int i = 0;i < antallE; i++) 
		{	
      		int n = random.nextInt(9);
        	randomArr[i] = n;	
		} 

		//Array with random numbers from 0 - 100000.
		int[] randomArr2 = new int[antallE];

		for (int i = 0;i < antallE; i++) 
		{
      		int n = random.nextInt(100000);
        	randomArr2[i] = n;	
		} 

		//Array with ascending numbers
		int[] ascendArr = new int[antallE];

		for (int i = 0;i < antallE; i++) 
		{
      		int n = i + 2;
        	ascendArr[i] = n;	
		} 

		//Array with descending numbers
		int[] descendArr = reverseArray(ascendArr);

		System.out.println("\n**** SELECTION SORT ****");
		int[] selectionSort1 = test.SelectionSort(randomArr);
		printArr("Selection Sort on array with ten random numbers (0-9): ",selectionSort1);
		int[] selectionSort2 = test.SelectionSort(ascendArr);
		printArr("\nSelection Sort on array with ten ascending numbers: ",selectionSort2);		
		int[] selectionSort3 = test.SelectionSort(descendArr);
		printArr("\nSelection Sort on array with ten descending numbers: ",selectionSort3);	

		// int[] selectionSort4 = test.SelectionSort(randomArr2); //test Array with random numbers from 0 - 100000.
		
		System.out.println("\n**** INSERTION SORT ****");
		int[] insertionSort1 = test.InsertionSort(randomArr);
		printArr("Insertion Sort on array with ten random numbers (0-9): ",insertionSort1);
		int[] insertionSort2 = test.InsertionSort(ascendArr);
		printArr("\nInsertion Sort on array with ten ascending numbers: ",insertionSort2);		
		int[] insertionSort3 = test.InsertionSort(descendArr);
		printArr("\nInsertion Sort on array with ten descending numbers: ",insertionSort3);	

		// int[] insertionSort4 = test.InsertionSort(randomArr2); //test Array with random numbers from 0 - 100000.


		System.out.println("\n**** QUICK SORT ****");
		int[] quickSort1 = test.quickSort(randomArr);
		printArr("Quick Sort on array with ten random numbers (0-9): ",quickSort1);
		int[] quickSort2 = test.quickSort(ascendArr);
		printArr("\nQuick Sort on array with ten ascending numbers: ",quickSort2);		
		int[] quickSort3 = test.quickSort(descendArr);
		printArr("\nQuick Sort on array with ten descending numbers: ",quickSort3);	

	 	//int[] quickSort4= test.quickSort(randomArr2); //test Array with random numbers from 0 - 100000.


		System.out.println("\n**** BUCKET SORT ****");
		int[] bucketSort1 = test.bucketSort(randomArr);
		printArr("Bucket Sort on array with ten random numbers (0-9): ",bucketSort1);
		int[] bucketSort2 = test.bucketSort(ascendArr);
		printArr("\nBucket Sort on array with ten ascending numbers: ",bucketSort2);		
		int[] bucketSort3 = test.bucketSort(descendArr);
		printArr("\nBucket Sort on array with ten descending numbers: ",bucketSort3);



		// int[] bucketSort4 = test.bucketSort(randomArr2); //test Array with random numbers from 0 - 100000.



		//!!!!!!!TIME TESTING ARRAY:SORT ON EACH ARRAY!!!!
		
		// long t = System.nanoTime(); // nanosek
		// Arrays.sort(ascendArr); 
		// double tid = (System.nanoTime()-t)/10000000.0; // millisek
		// System.out.println(tid);

		// long t = System.nanoTime(); // nanosek
		// Arrays.sort(descendArr); 
		// double tid = (System.nanoTime()-t)/10000000.0; // millisek
		// System.out.println(tid);

		// long t = System.nanoTime(); // nanosek
		// Arrays.sort(randomArr); 
		// double tid = (System.nanoTime()-t)/10000000.0; // millisek
		// System.out.println(tid);

		// long t = System.nanoTime(); // nanosek
		// Arrays.sort(randomArr2); 
		// double tid = (System.nanoTime()-t)/10000000.0; // millisek
		// System.out.println(tid);



	}

	//prints arrays content
	public static void printArr(String s ,int[] arr)
	{
		System.out.print(s);
		for (int i = 0;i < arr.length ;i++ ) 
		{
			System.out.print(arr[i] + " ");	
		}
		System.out.println();
	}

	//Reverses inputed array
	public static int[] reverseArray(int[] arr) 
	{
		int[] reversedArr = new int[arr.length];

    	for (int i = 0; i < arr.length; i++)
    	{
        	reversedArr[i] = arr[(arr.length-1)-i];
    	}
    	return reversedArr;
	}

}