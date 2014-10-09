/*
 * Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break on landing. We make a few assumptions:

…..An egg that survives a fall can be used again.
…..A broken egg must be discarded.
…..The effect of a fall is the same for all eggs.
…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
…..If an egg survives a fall then it would survive a shorter fall.
…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.

If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way. Drop the egg from the first-floor window; if it survives, drop it from the second floor window. Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work in all cases?
The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that total number of trials are minimized.
 */
public class eggDrop {
	//time: O(n * k^2);
	public static int trial(int k, int n) {
		int[][] matrix = new int[k + 1][n + 1];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = -1;
			}
		}
		return trial(k, n, matrix);
	}
	public static int trial(int k, int n, int[][] matrix) {
		if(n == 1) {
			matrix[k][n] = k;
			return matrix[k][n];
		}
		if(k == 1 || k == 0) {
			matrix[k][n] = k;
			return matrix[k][n];
		}
		if(matrix[k][n] != -1) {
			return matrix[k][n];
		}
		matrix[k][n] = Integer.MAX_VALUE;
 		for(int x = 1; x <= k; x++) {
			int nn = Math.max(trial(x - 1, n - 1, matrix), trial(k - x, n, matrix)); //an egg may or may not break by dropping from xth floor.
			if(nn < matrix[k][n]) {
				matrix[k][n] = nn;
			}
		}
 		matrix[k][n]++;
		return matrix[k][n];
	}
	public static void main(String[] args) {
		System.out.println(trial(36, 2));
	}
}
