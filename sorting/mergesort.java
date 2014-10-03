public class mergesort {
	/*
	 * mergeSort
	 */
	public void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	public void mergeSort(int[] array, int start, int end) {
		int middle = start + (end - start) / 2;
		if(start >= end) return;
		mergeSort(array, start, middle);
		mergeSort(array, middle + 1, end);
		merge(array, start, middle, end);
	}
	public void merge(int[] array, int start, int middle, int end) {
		int[] helper = new int[end - start + 1];
		for(int i = start; i <= end; i++) {
			helper[i - start] = array[i];
        }
        int left = start, right = middle + 1, count = start;
        while(left <= middle && right <= end) {
        	if(helper[left - start] <= helper[right - start]) {
        		array[count++] = helper[left - start];
        		left++;
        	}
        	else {
        		array[count++] = helper[right - start];
        		right++;
        	}
        }
        while(left <= middle) {
        	array[count++] = helper[left - start];
        	left++;
        }
	}
	public static void main(String[] args) {
		int[] array = {1,2,2,2,3, 10, 3, 40, 20, 50, 80, 70,12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		mergesort ss = new mergesort();
		ss.mergeSort(array);
		for(int i : array)
			System.out.println(i);
	}
}
