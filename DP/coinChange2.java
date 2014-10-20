public class coinChange2 {
	public static int coin(int N, int[] S) {
		int[] sum = {0};
		coin(N, S, 0, sum);
		return sum[0];
	}
	public static int[] coin(int N, int[] S, int position, int[] sum) {
		if(N == 0) {
			sum[0]++;
			return sum;
		}
		for(int i = 0; i < S.length; i++) {
			if(S[i] <= N) {
				coin(N - S[i], S, i, sum);
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] array = {2,3,7};
		System.out.println(coin(7, array));
	}
}