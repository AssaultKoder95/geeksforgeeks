public class heapsort {
	/*
	 * heapSort
	 */

	public void heapSort(int[] array) {
		int start = (array.length - 2) / 2;
		heapify(array); // build max heap, add the elements in array into the heap one by one: NlogN
		shiftUp(array); // exchange the peek with the last ele in the array, fill the peek with the max number in the heap: NlogN
	}
	public void heapify(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int index = i;
			while((index - 1) / 2 >= 0) {
				int parent = (index - 1) / 2;
				if(array[parent] < array[index]) {
					swap(array, parent, index);
					index = parent;
				}
				else break;
			}
		}
	}
	public void shiftUp(int[] array) {
		for(int i = array.length - 1; i >= 0; i--) {
			int index = 0;
			swap(array, 0, i);
			while(2 * index + 1 < i) {
				int left = 2 * index + 1;
				int in = index;
				if(array[in] < array[left]) {
					in = left;
				}
				if(left + 1 < i && array[in] < array[left + 1]) {
					in = left + 1;
				}
				if(index == in) {
					break;
				}
				swap(array, in, index);
				index = in;
			}
		}
	}
	public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		int[] array = {1,2,2,2,3, 10, 3, 40, 20, 50, 80, 70,12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		heapsort ss = new heapsort();
		ss.heapSort(array);
		for(int i : array)
			System.out.println(i);
	}
}