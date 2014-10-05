/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. 
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class coinChange {
	public static int coin(int N, int[] S) {
		return coin(N, S, S.length - 1);
	}
	public static int coin(int N, int[] S, int position) {
		int sum = 0;
		if(position == 0) {
			if(N % S[0] == 0) return 1;
			else return Integer.MIN_VALUE;
		}
		int num = N / S[position];
		for(int j = 0; j <= num; j++) {
			int ways = coin(N - j * S[position], S, position - 1);
			if(ways > 0) {
				sum += ways;
			}
		}
		return sum;
	}
}
