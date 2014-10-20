
public class arrayRotate {
	public static void rotate(int[] array, int k) {
		rotate(array, 0, array.length - 1);
		rotate(array, 0, k - 1);
		rotate(array, k, array.length - 1);
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void rotate(int[] array, int start, int end) {
		while(start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		for(int i = 0; i < array.length; i++) {
		    rotate(array, i);
		}
	}
}
