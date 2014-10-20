public class printBST {
	public static void print(int[] array, int start, int end) {
		if(start > end) return;
		print(array, start * 2 + 1, end);
		System.out.println(array[start]);
		print(array, start * 2 + 2, end);
	}
	public static void main(String[] args) {
		int[] array = {4,2,5,1,3};
		print(array, 0, 4);
	}
}