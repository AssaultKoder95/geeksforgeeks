/*
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. 
 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class knapsack {
	public static int knap(int[] values, int[] weights, int w) {
		int[][] result = new int[values.length + 1][w + 1];
		if(values.length == 0) return 0;
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j <= w; j++) {
			    result[i][j] = -1;
			}
		}
		return knap(values, weights, values.length, w, result);
	}
	public static int knap(int[] values, int[] weights, int position, int w, int[][] result) {
		if(position == 0 || w == 0) {
			result[position][w] = 0;
			return result[position][w];
		}
		if(result[position][w] != -1) return result[position][w];
		if(weights[position - 1] <= w) {
		    result[position][w] = Math.max(knap(values, weights, position - 1, w - weights[position - 1], result) + values[position - 1], knap(values, weights, position - 1, w, result));
		}
		else {
			result[position][w] = knap(values, weights, position - 1, w, result);
		}
		return result[position][w];
	}
}
