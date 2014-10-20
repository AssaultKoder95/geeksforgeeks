public class snakeLadder {
	public static int steps(int[][] matrix) {
		int[][] cache = new int[matrix.length][matrix[0].length];
		return steps(matrix, cache, matrix.length, matrix[0].length);
	}
	public static int steps(int[][] matrix, int[][] cache, int row, int col) {
		if(row == matrix.length && col == 0)  {
			return 0;
		}
		if(cache[row][col] != 0) {
			return cache[row][col];
		}
		if(matrix[row][col] != 0) {
			int num = matrix[row][col];
			int row2 = num / matrix[0].length;
			int col2 = num % matrix[0].length;
			int n = row * matrix[0].length + col;
			int res = steps(matrix, cache, row2, col2);
			for(int i = Math.max(0, n - 6); i < n; i++) {
				int r = i / matrix[0].length;
				int c = i % matrix[0].length;
				res = Math.min(res, steps(matrix, cache, r, c));
			}
		}
		cache[row][col] = res + 1;
		return res;
	}
}