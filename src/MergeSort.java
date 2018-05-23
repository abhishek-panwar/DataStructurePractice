
public class MergeSort {

	/***
	 * divides the array arr into half recursively
	 * @param arr
	 */
	private static void mergeSort(int[] arr)
	{
		//int n = arr.length;
		if(arr.length<2)
			return;
		int mid = arr.length/2; // finds the mid of the array
		//creates two arrays to hold two halves of the main array arr
		int[] left = new int[mid];
		int[] right = new int[arr.length-mid];
		//divide the array into two left and right arrays wrt mid
		for(int i=0;i<mid;i++)
			left[i] = arr[i];
		for(int i=mid;i<arr.length;i++)
			right[i-mid] = arr[i];
		// recursively call the mergesort method for both the arrays to divide them further
		mergeSort(left); 
		mergeSort(right);
		
		// after the division of arrays are done 
		// we need to merge them in a sorted ordere
		merge(arr,left,right);
		
	}
	private static void merge(int[] arr, int[] left, int[] right)
	{
		int i=0,j=0,k=0;
		while(i<left.length && j<right.length)
		{
			//stores the element (whichever is lesser) in arr
			if(left[i] < right[j])
			{
				arr[k++] = left[i++];
			}
			else
			{
				arr[k++] = right[j++];
			}
		}
		//after compeletion of above loop, there might be the case when wither of left or right 
		// still left with some values
		// stores those values in arr
		while(i<left.length)
		{
			arr[k++] = left[i++];
		}
		while(j<right.length)
		{
			arr[k++] = right[j++];
		}
		
	}
	
	private static void print(int[] arr)
	{
		for(int i : arr)
			System.out.print(i+" ");
	}
	
	public static void main(String args[])
	{
		int[] arr = {6,2,3,1,9,10,15,13,12,17};
		System.out.println("unsorted array...........");
		print(arr);
		mergeSort(arr);
		
		System.out.println("\n\nsorted array...........");
		print(arr);
		
	}
	
}


