
public class Sorting {

	int[] array = { 1, 8, 4, 6, 9, 2, 4, 12, 15, 11, 18, 14, 16 };

	public static void main(String[] args) {

		Sorting s = new Sorting();
		s.print();
		// s.bubbleSort();
		s.insertionSort();
		// s.selectionSort();
		// s.print();

		// System.out.println("# elements: "+s.array.length);

	}

	public void bubbleSort() {
		int count = 0;
		boolean swap = true;
		for (int i = array.length; i > 0 && swap; i--) {
			/* the use of swap is for optimizing the traditional bubble sort in which even
			 after the array is sorted
			 control executes every iteration. that leads to more time complexity
			 the purpose of using swap= true inside the inner loop is that, if for i= some
			 value it doesn't go to
			 inner loop if condition.. that means if condition never holds true anymore,
			 means array is sorted now.
			 hence value of swap will remain false. which leads to terminate outer loop
			 hence optimized time complexity*/
			swap = false;
			for (int j = 1; j < i; j++) {
				count++;
				if (array[j - 1] > array[j]) {
					swap(j - 1, j);
					// System.out.println("swaped: ("+(j-1)+", "+(j)+")");
					swap = true;
					print();
				}
			}
		}
		System.out.println("iterations: " + count);
	}

	public void insertionSort() {
		for (int i = 1; i < array.length; i++) {

			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					swap(j, j + 1);
					print();
				}
			}
		}
	}

	public void selectionSort() {
		for (int i = 0; i < array.length; i++) {
			int minimum = i;
			for (int j = i; j < array.length; j++) {
				if (array[minimum] > array[j])
					minimum = j;
			}
			swap(i, minimum);
			print();
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
