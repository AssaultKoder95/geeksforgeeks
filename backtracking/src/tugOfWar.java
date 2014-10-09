/*
 * Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible. If n is even, then sizes of two subsets must be strictly n/2 and if n is odd, then size of one subset must be (n-1)/2 and size of other subset must be (n+1)/2.
 */
public class tugOfWar {
	public static int tug(int[] array) {
		int[] left = new int[array.length / 2];
		int[] right = new int[array.length - array.length / 2];
		int[] diff = {Integer.MAX_VALUE};
		int n = tug(array, left, right, 0, 0, diff);
		return n;
	}
	public static int tug(int[] array, int[] left, int[] right, int leftindex, int rightindex, int[] diff) {
		if(leftindex == left.length && rightindex == right.length) {
			int leftSum = 0;
			for(int i = 0; i < left.length; i++) {
				leftSum += left[i];
			}
			int rightSum = 0;
			for(int i = 0; i < right.length; i++) {
				rightSum += right[i];
			}
			diff[0] = Math.min(Math.abs(leftSum - rightSum), diff[0]);
			return diff[0];
		}
		if(leftindex < left.length) {
			left[leftindex] = array[leftindex + rightindex];
			tug(array, left, right, leftindex+1, rightindex, diff);
		}
		if(rightindex < right.length) {
			right[rightindex] = array[leftindex + rightindex];
			tug(array, left, right, leftindex, rightindex+1, diff);
		}
		return diff[0];
	}
	public static void main(String[] args) {
		int[] array = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
		System.out.println(tug(array));
		int[] array2 = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		System.out.println(tug(array2));
	}
}
