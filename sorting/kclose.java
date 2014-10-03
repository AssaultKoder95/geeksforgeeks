/*
 * Find k closest elements to a given value
 * Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]. 
 */
//O(k + log n)
public class kclose {
	public static int[] closest(int[] array, int elem, int k) {
		int index = find(array, 0, array.length - 1, elem, 0);
		int left = index - 1, right = index + 1;
		int[] result = new int[k];
		int i = array[index] == elem? 0 : 1;
		if(array[index] != elem) {
			result[0] = array[index];
		}
		while(i != k && (left >= 0 || right < array.length)) {
			int leftDiff = Math.abs(elem - array[left]);
			int rightDiff = Math.abs(elem - array[right]);
			result[i++] = leftDiff < rightDiff? array[left] : array[right];
			left = leftDiff < rightDiff? left - 1 : left;
			right = leftDiff < rightDiff? right : right + 1;
		}
		return result;
	}
	public static int find(int[] array, int start, int end, int elem, int close) {
		if(start > end) {
			if(start < array.length && Math.abs(array[start] - elem) < Math.abs(array[close] - elem)) {
				close = start;
			}
			if(end >= 0 && Math.abs(array[end] - elem) < Math.abs(array[close] - elem)) {
				close = end;
			}
		}
		int middle = start + (end - start) / 2;
		if(array[middle] == elem) return middle;
		else if(array[middle] < elem) {
			close = middle;
			return find(array, middle + 1, end, elem, close);
		}
		else {
			close = middle;
			return find(array, start, middle - 1, elem, close);
		}
	}
	public static void main(String[] args) {
		int arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int[] array = closest(arr, 35, 4);
        for(int num : array) {
        	System.out.println(num);
        }
	}
}