public class unsortedSubarray {
	public static int[] find(int[] array) {
		int left = findLeft(array, 0, array.length - 1);
		int right = findRight(array, 0, array.length - 1);
		System.out.println(left + " " + right);
		int[] arr = new int[right - left - 1];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = array[i + left];
		}
		return arr;
	}
	public static int findRight(int[] array, int left, int right) {
		if(left > right) {
			if(right >= 1 && array[right] >= array[right - 1]) return right - 1;
			else return right >= 0? right : right + 1;
		}
		int middle = (left + right) / 2;
		if(sorted(array, left, middle)) {
			return findLeft(array, middle + 1, right);
		}
		else return findLeft(array, middle + 1, right);
	}
	public static int findLeft(int[] array, int left, int right) {
		if(left > right) {
			if(left < array.length - 1 && array[left] <= array[left + 1]) return left;
			else return left < array.length? left : left - 1;
		}
		int middle = (left + right) / 2;
		if(sorted(array, middle, right)) {
			return findLeft(array, middle - 1, left);
		}
		else return findLeft(array, middle + 1, right);
	}
	public static boolean sorted(int[] array, int left, int right) {
		for(int i = left; i < right - 1; i++) {
			if(array[left] > array[left+1]) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int[] array = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		int[] res = find(array);
		for(int i : res)
			System.out.println(i);
	}
}