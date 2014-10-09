/*
 * Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once. A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in graph) from the last vertex to the first vertex of the Hamiltonian Path. Determine whether a given graph contains Hamiltonian Cycle or not. If it contains, then print the path. Following are the input and output of the required function.

Input:
A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] is adjacency matrix representation of the graph. A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.

Output:
An array path[V] that should contain the Hamiltonian Path. path[i] should represent the ith vertex in the Hamiltonian Path. The code should also return false if there is no Hamiltonian Cycle in the graph.
 */
public class hamiltonCycle {
	public static boolean cycle(int[][] graph) {
		int[] path = new int[graph.length];
		path[0] = 0;
		boolean[] b = new boolean[graph.length];
		b[0] = true;
		if(cycle(graph, 0, path, 1, b)) {
			for(int num : path) {
				System.out.println(num);
			}
			return true;
		}
		return false;
	}
	public static boolean cycle(int[][] graph, int start, int[] path, int index, boolean[] marked) {
		if(index == graph.length) {
			if(graph[path[path.length - 1]][start] == 1) {
				return true;
			}
			else {
				return false;
			}
		}
		for(int i = 0; i < graph.length; i++) {
			if(!marked[i] && graph[path[index - 1]][i] == 1) {
				marked[i] = true;
				path[index] = i;
				if(cycle(graph, start, path, index + 1, marked)) {
					return true;
				}
				marked[i] = false;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] graph = {{0,1,0,1,0},{1,0,1,1,1},{0,1,0,0,1},{1,1,0,0,1},{0,1,1,1,0}};
		System.out.println(cycle(graph));
		int[][] falsegraph = {{0,1,0,1,0},{1,0,1,1,1},{0,1,0,0,1},{1,1,0,0,0},{0,1,1,0,0}};
		System.out.println(cycle(falsegraph));
	}
}
