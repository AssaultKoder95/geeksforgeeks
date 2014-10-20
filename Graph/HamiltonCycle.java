/*
 * A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in graph) from the last vertex to the first vertex of the Hamiltonian Path. Determine whether a given graph contains Hamiltonian Cycle or not. If it contains, then print the path. 
 */
public class HamiltonCycle {
	//backtracking
	public static void cycle(int[][] graph) {
		int[] path = new int[graph.length];
		path[0] = 0;
		if(cycle(graph, new boolean[graph.length], path, 1)) {
			for(int i : path) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		else System.out.println("no such path");
	}
	public static boolean cycle(int[][] graph, boolean[] visited, int[] path, int position) {
		if(position == path.length && graph[0][path[path.length - 1]] == 1) {
			return true;
		}
		else if(position == path.length) {
			return false;
		}
		for(int i = 1; i < graph.length; i++) {
			if(!visited[i] && graph[path[position - 1]][i] == 1) {
				visited[i] = true;
				path[position] = i;
				if(cycle(graph, visited, path, position + 1)) {
					return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] graph = {{0, 1, 0, 1, 0},{1, 0, 1, 1, 1},{0, 1, 0, 0, 1},{1, 1, 0, 0, 1},{0, 1, 1, 1, 0}};
		cycle(graph);
		int[][] graph2 = {{0, 1, 0, 1, 0},
                      {1, 0, 1, 1, 1},
                      {0, 1, 0, 0, 1},
                      {1, 1, 0, 0, 0},
                      {0, 1, 1, 0, 0},
                     };	
        cycle(graph2);
	}
}