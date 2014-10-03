public class selectionsort {
	/*
	 * selectionSort
	 */

	public void selectionSort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int minIndex = i;
			for(int j = i; j < array.length; j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			swap(array, i, minIndex);
		}
	}
	public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		int[] array = {1,2,2,2,3, 10, 3, 40, 20, 50, 80, 70,12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		selectionsort ss = new selectionsort();
		ss.selectionSort(array);
		for(int i : array)
			System.out.println(i);
	}
}