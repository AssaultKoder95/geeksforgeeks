public class MaxCircularSubarray {
	public static int max(int[] array) {
		int max = maxSum(array);
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
			array[i] = -array[i];
		}
		int min = -maxSum(array);
		int circularSum = sum - min;
		return Math.max(max, circularSum);
	}
	public static int maxSum(int[] array) {
		int max = 0;
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
			if(sum > max) {
				max = sum;
			}
			if(sum < 0) {
				sum = 0;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] array = {8, -8, 9, -9, 10, -11, 12};
		System.out.println(max(array));
		int[] array2 = {10, -3, -4, 7, 6, 5, -4, -1};
		System.out.println(max(array2));
		int[] array3 = {-1, 40, -14, 7, 6, 5, -4, -1};
		System.out.println(max(array3));
		int[] array4 = {-1, -1, 3, -5};
		System.out.println(max(array4));
	}
}