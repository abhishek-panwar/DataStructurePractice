/***
 * Binary Heap implementation using int array
 * 
 * @author Abhishek Panwar
 */

import java.util.Arrays;

public class BinaryHeapImplementation {

	public static void main(String[] args) {

		BinaryHeap bh = new BinaryHeap();
		bh.insert(9);
		bh.insert(5);
		bh.insert(6);
		bh.insert(2);
		bh.insert(3);
		bh.insert(1);
		
		//bh.printHeap();
		bh.deleteMinimum();
		//bh.printHeap();
		bh.deleteMinimum();
		//bh.printHeap();
		bh.deleteMinimum();
		//bh.printHeap();
		bh.deleteMinimum();
		//bh.printHeap();
	}

}

class BinaryHeap
{
	int[] heap;
	int size;
	public BinaryHeap()
	{
		heap = new int[5]; //default size of heap
		size=0;
		
	}
	
	//inserts a new value into heap
	public void insert(int element)
	{
		if(size>=heap.length-1)
		{
			heap = Arrays.copyOf(heap, heap.length * 2);
		}
		size++;
		heap[size] = element;
		percolateUp(size);
	}
	
	//balance the heap by maintaining its properties
	//puts the value at last index to its appropriate location
	//also known as heapify up method
	private void percolateUp(int size)
	{
		while(size/2 > 0)
		{
			if(heap[size]< heap[size/2])
				switchIndices(size, size/2);
			size = size/2;
		}
	}
	//switch the values between two indices of heap
	private void switchIndices(int index1, int index2)
	{
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	
	//prints the heap in array format
	public void printHeap()
	{
		for(int i : heap)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//only return the minimum elemenet value
	//peek()
	public int getMinimum()
	{
		return heap[1];
	}
	
	//deletes the minimum valued element from heap
	public void deleteMinimum()
	{
		int min = heap[1];
		heap[1] = heap[size];
		heap[size] = 0;
		size--;
		
		percolateDown(1);
	}
	//balance the heap by maintaining its properties
	//puts the value at index to its appropriate location
	//also known as heapify down method
	private void percolateDown(int index)
	{
		while(index*2<=size)
		{
			int minChild = findMinChild(index);
			if(heap[index]>heap[minChild])
			{
				switchIndices(index, minChild);
			}
			index = minChild;
		}
	}
	//find the minimum of two children of a node at position index
	private int findMinChild(int index)
	{
		if(index*2+1>size)
			return index*2;
		else
			if(heap[index*2]<heap[index*2+1])
				return index*2;
			else
				return index*2+1;
	}
	
}
