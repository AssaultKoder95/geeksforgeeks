/*
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
shows the first 11 ugly numbers. By convention, 1 is included.
Write a program to find and print the 150′th ugly number.
 */
public class uglyNumber {
	public static int[] getUgly(int num) {
		int[] array = new int[num];
		array[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		int next2 = array[i2] * 2, next3 = array[i3] * 3, next5 = array[i5] * 5;
		for(int i = 1; i < num; i++) {
			int no = Math.min(Math.min(next2, next3), next5);
			array[i] = no;
			if(no == next2) {
				i2++;
				next2 = array[i2] * 2;
			}
			if(no == next3) {
				i3++;
				next3 = array[i3] * 3;
			}
			if(no == next5) {
				i5++;
				next5 = array[i5] * 5;
			}
			System.out.println(no);
		}
		return array;
	}
	public static void main(String[] args) {
		getUgly(30);
	}
}
