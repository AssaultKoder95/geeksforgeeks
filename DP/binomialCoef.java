/*
 * Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k). 
 * For example, your function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.
 */
public class binomialCoef {
	/*
	 * C(n, k) = C(n-1, k-1) + C(n-1, k)
     * C(n, 0) = C(n, n) = 1 
	 */
	public static int binomial(int n, int k) {
		int[] table = new int[k + 1];
		table[0] = 1;
		for(int i = 1; i <= n; i++) {
			for(int j = Math.min(i, k); j > 0; j--) {
				table[j] = table[j] + table[j - 1];
			}
		}
		return table[k];
	}
}
