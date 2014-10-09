/*
 * Given a 2D array, find the maximum sum subarray in it.
 */
public class MaxSumRectangle {
	//O(n^3)
	public static int maxSum(int[][] rec) {
		int[][] sumrec = new int[rec.length][rec[0].length];
		for(int i = 1; i < rec.length; i++) {
			sumrec[i][0] = sumrec[i - 1][0] + rec[i][0];
		}
		for(int j = 1; j < rec[0].length; j++) {
			sumrec[0][j] = sumrec[0][j - 1] + rec[0][j];
		}
		for(int i = 1; i < rec.length; i++) {
			for(int j = 1; j < rec[0].length; j++) {
				sumrec[i][j] = sumrec[i - 1][j] + sumrec[i][j - 1] - sumrec[i - 1][j - 1] + rec[i][j];
			}
		}
		int max = Integer.MIN_VALUE;
		//fix left and right columns and find the maximum continuous rows.
		for(int left = 0; left < rec[0].length; left++) {
			for(int right = left; right < rec[0].length; right++) {
				int sum = sumrec[0][right] - sumrec[0][left];
				for(int row = 1; row < rec.length; row++) {
					if(sum < 0) {
						sum = 0;
					}
					sum += sumrec[row][right] - sumrec[row][left] - sumrec[row - 1][right] + sumrec[row - 1][left];
					max = Math.max(max, sum);
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,2,-1,-4,-20}, {-8,-3,4,2,1},{3,8,10,1,3},{-4,-1,1,7,-6}};
		System.out.println(maxSum(matrix));
	}
}
