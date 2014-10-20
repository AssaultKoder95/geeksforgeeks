/*
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

Example:
The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 */
public class inversions {
	//O(n log n)
	public static int count(int[] array) {
		return count(array, 0, array.length - 1);
	}
	public static int count(int[] array, int left, int right) {
		if(left >= right) return 0;
		int middle = left + (right - left) / 2;
		int leftC = count(array, left, middle);
		int rightC = count(array, middle + 1, right);
		return merge(array, left, middle, right, leftC, rightC);
	}
	public static int merge(int[] array, int left, int middle, int right, int leftC, int rightC) {
		int l1 = left, l2 = middle + 1;
		int[] helper = new int[array.length];
		int n = leftC + rightC;
		for(int i = 0; i < array.length; i++) {
			helper[i] = array[i];
		}
		int count = left;
		while(l1 <= middle && l2 <= right) {
			if(helper[l1] <= helper[l2]) {
				array[count++] = helper[l1++];
			}
			else {
				n += middle - l1 + 1;
				array[count++] = helper[l2++];
			}
		}
		while(l1 <= middle) {
			array[count++] = helper[l1++];
		}
		return n;
	}
	public static void main(String[] args) {
		int[] array = {2,4,1,3,5};
		System.out.println(count(array));
		int[] array2 = {5,2,3,4,5,2,2,6,5,6,2,2};
		int n = count(array2);
		System.out.println(n);
	}
}
