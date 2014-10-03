public class insertionsort {
	/*
	 * insertionSort
	 */

	public void insertionSort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int num = array[i];
			int index = i - 1;
			while(index >= 0 && num < array[index]) {
				array[index + 1] = array[index];
				index--;
			}
			array[index + 1] = num;
		}
	}

	public static void main(String[] args) {
		int[] array = {1,2,2,2,3, 10, 3, 40, 20, 50, 80, 70,12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		insertionsort ss = new insertionsort();
		ss.insertionSort(array);
		for(int i : array)
			System.out.println(i);
	}
}