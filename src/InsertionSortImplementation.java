
public class InsertionSortImplementation {
	
	int[] array = { 1, 8, 4, 6, 9, 2, 4, 12, 15, 11, 18, 14, 16 };

	public static void main(String[] args) {

		InsertionSortImplementation s = new InsertionSortImplementation();
		System.out.println("unsorted array...........");
		s.print();
		s.insertionSort();
		System.out.println("\nsorted array...........");
		s.print();
	}
	
	
	public void insertionSort() {
		for (int i = 1; i < array.length; i++) {

			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					swap(j, j + 1);
					//print();  //uncomment to check each iteration of the sorting process
				}
			}
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
