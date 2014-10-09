/*
 * Given an array arr[0 ... n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing. Write a function that takes an array as argument and returns the length of the longest bitonic subsequence.
A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.
 */
public class longBitonicSeq {
	public static int bitonic(int[] array) {
		int[] left = new int[array.length];
		int[] right = new int[array.length];
		left[0] = 1;
		right[array.length - 1] = 1;
		for(int i = 1; i < array.length; i++) {
			int count = 0;
			for(int j = 0; j < i; j++) {
				if(array[j] < array[i]) {
					count = Math.max(count, left[j]);
				}
			}
			left[i] = count + 1;
		}
		int max = left[array.length - 1];
		for(int i = array.length - 2; i >= 0; i--) {
			int count = 0;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[i]) {
					count = Math.max(count, right[j]);
				}
			}
			right[i] = count + 1;
			max = Math.max(left[i] + right[i] - 1, max);
		}
		return max;
	}
}
