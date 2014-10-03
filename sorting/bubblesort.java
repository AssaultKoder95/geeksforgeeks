public class bubblesort {
	/*
	 * bubbleSort
	 */

	public void bubbleSort(int[] array) {
		boolean change = true;
		while(change) {
			change = false;
			for(int j = 1; j < array.length; j++) {
				if(array[j] < array[j - 1]) {
					swap(array, j - 1, j);
					change = true;
				}
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
		bubblesort ss = new bubblesort();
		ss.bubbleSort(array);
		for(int i : array)
			System.out.println(i);
	}
}