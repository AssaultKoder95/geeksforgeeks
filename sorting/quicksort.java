import java.util.Random;
public class quicksort {
	/*
	 * quickSort, pay attention to the partition part: the end point of pivot
	 */

	public void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	public void quickSort(int[] array, int start, int end) {
		if(start >= end) return;
		int pivot = partition(array, start, end);
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);  
	}
	public int partition(int[] array, int start, int end) {
		int pivot = array[start + (end - start) / 2];  //must have pivot determined at the beginning, don't use int pivot = start + (end - start) / 2 !!!!
		int left = start;
		swap(array, start + (end - start) / 2, end);
		while(start < end) {
			if(array[start] < pivot) {
				swap(array, left++, start);
			}
			start++;
		}
		swap(array, left, end);
		return left;
	}
	public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,2,2,3, 10, 3, 40, 20, 50, 80, 70,12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		quicksort ss = new quicksort();
		ss.quickSort(array);
		for(int i : array)
			System.out.println(i);
	}
}