
public class Searching {

	int[] array = {1,8,4,6,9,2,4,12,15,11,18,14,16};	
	int[] sortedArray = {1,2,3,4,5,6,7,8,9,12,14,16,17,18,23,25};
	public static void main(String args[])
	{
		Searching s = new Searching();
		//System.out.println(s.linearSearch(s.array, 11));
		//s.print(s.array);
		System.out.println(s.binarySearch(s.sortedArray, 2));
	}
	
	public int linearSearch(int[] arr, int element)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(element==arr[i])
				return i;
		}
		return -1;
		
	}
	
	public int binarySearch(int[] arr, int element)
	{
		int start = 0;
		int end = arr.length-1;
		int mid;
		while(start<=end)
		{
			mid = start + (end-start)/2; // better way of writing (start+end)/2 to avoid Max value ondition of Integer
			//System.out.println("start "+start+"....end "+end+" ....mid "+mid+"...value "+arr[mid]);
			if(arr[mid]==element)
				return mid;
			else if(element<arr[mid])
				end= mid-1;
			else
				start = mid+1;
		}
		return -1;
		
	}
	
	public void print(int[] arr)
	{
		for(int i : arr)
		{
			System.out.print(i+" ");
		}
	}
}

