/*
 * Given a boolean 2D matrix, find the number of islands.
 * This is an variation of the standard problem: “Counting number of connected components in a undirected graph”.
 */
import java.util.*;
public class countIslands {
	public static List<Integer[]> islands(int[][] matrix) {
		List<Integer[]> list = new ArrayList<Integer[]> ();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(!visited[i][j] && matrix[i][j] == 1) {
					Integer[] position = {i, j};
					list.add(position);
					dfs(matrix, visited, i, j);
				}
			}
		}
		return list;
	}
	public static void dfs(int[][] matrix, boolean[][] visited, int row, int col) {
		visited[row][col] = true;
		for(int r = row - 1; r <= row + 1; r++) {
			for(int c = col - 1; c <= col + 1; c++) {
				if(!(r == row && c == col) && r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] == 1 && !visited[r][c]) {
					dfs(matrix, visited, r, c);
				}
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,1,0,0,0}, {0,1,0,0,1}, {1,0,0,1,1}, {0,0,0,0,0},{1,0,1,0,1}};
		List<Integer[]> list = islands(matrix);
		for(Integer[] pos : list) {
			System.out.println(pos[0] + " " + pos[1]);
		}
	}
}