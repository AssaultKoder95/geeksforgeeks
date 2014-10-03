//Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
//Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that sorting this subarray makes the whole array sorted.
//O(n)
public class unsortedSubarray {

	public int[] find(int[] array) {
		int left = 0, right = array.length - 1;
		for(int i = 1; i < array.length; i++) {
			if(array[i] < array[i - 1]) {
				left = i - 1;
				break;
			}
		}
		for(int i = array.length - 1; i > 0; i--) {
			if(array[i] < array[i - 1]) {
				right = i;
				break;
			}
		}
		int min = array[left];
		int max = array[right];
		for(int i = left; i <= right; i++) {
			min = Math.min(array[i], min);
			max = Math.max(array[i], max);
		}
		for(int i = 0; i < left; i++) {
			if(array[i] > min) {
				left = i;
				break;
			}
		}
		for(int i = array.length - 1; i > right; i--) {
			if(array[i] < max) {
				right = i;
				break;
			}
		}
		int[] res = {left, right};
		return res;
	}
	public static void main(String[] args) {
		unsortedSubarray us = new unsortedSubarray();
		int[] array = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		int[] res = us.find(array);
		for(int i : res)
			System.out.println(i);
	}
}