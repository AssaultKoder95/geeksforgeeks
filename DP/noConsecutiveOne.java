/*
 * Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1′s.
 */
public class noConsecutiveOne {
	public static int count(int n) {
		if(n == 0) return 0;
		int[] a = new int[n];
		int[] b = new int[n];
		a[0] = 1; //end with 0
		b[0] = 1; //end with 1
		for(int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}
		return a[n - 1] + b[n - 1];
	}
}
