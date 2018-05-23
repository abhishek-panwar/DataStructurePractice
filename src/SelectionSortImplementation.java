
public class SelectionSortImplementation {

	int[] array = { 1, 8, 4, 6, 9, 2, 4, 12, 15, 11, 18, 14, 16 };

	public static void main(String[] args) {

		SelectionSortImplementation s = new SelectionSortImplementation();
		System.out.println("unsorted array...........");
		s.print();
		s.selectionSort();
		System.out.println("\nsorted array...........");
		s.print();
	}
	
	public void selectionSort() {
		for (int i = 0; i < array.length; i++) {
			int minimum = i;
			for (int j = i; j < array.length; j++) {
				if (array[minimum] > array[j])
					minimum = j;
			}
			swap(i, minimum);
			//print();  //uncomment to check each iteration of the sorting process
		}

	}

	public void swap(int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public void print() {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
