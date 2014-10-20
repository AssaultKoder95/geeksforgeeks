public class CountWalk {
	public static int countstep(int[][] graph, int u, int v, int k) {
		int[][][] count = new int[graph.length][graph[0].length][k + 1];
		for(int e = 0; e <= k; e++) {
			for(int i = 0; i < graph.length; i++) {
				for(int j = 0; j < graph.length; j++) {
					if(e == 0 && i == j) {
						count[i][j][e] = 1;
					}
					if(e == 1 && graph[i][j] == 1) {
						count[i][j][e] = 1;
					}
					if(e > 1) {
						for(int a = 0; a < graph.length; a++) {
							if(graph[i][a] == 1) {
								count[i][j][e] += count[a][j][e - 1]; 
							}
						}
					}
				}
			}
		}
		return count[u][v][k];
	}
	public static void main(String[] args) {
		int graph[][] = {{0, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}};
        System.out.println(countstep(graph, 0, 3, 2));
	}
}