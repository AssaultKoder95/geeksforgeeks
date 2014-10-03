import java.util.Random;
public class quicksort {
	/*
	 * quickSort
	 */

	public void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	public void quickSort(int[] array, int start, int end) {
		if(start >= end) return;
		int pivot = partition(array, start, end);
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot, end);  
	}
	public int partition(int[] array, int start, int end) {
		Random rd = new Random();
		int pivot = array[start + rd.nextInt(end - start)];  //must have pivot determined at the beginning, don't use int pivot = start + (end - start) / 2 !!!!
		int left = start, right = end;
		while(left <= right) {
			while(array[left] < pivot) {     //important: no "="
				left++;
			}
			while(array[right] > pivot) {
				right--;
			}
			if(left <= right) {
			    swap(array, left, right);
			    left++;
			    right--;
			}
		}
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