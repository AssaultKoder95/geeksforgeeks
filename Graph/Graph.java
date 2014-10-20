public class Graph {
	int V, E;
	Edge[] edge;
	public Graph(int V, int E) {
		this.V = V;
		this.E = E;
		edge = new Edge[E];
		parent = new parent[V];
	}

	public Edge[] getEdges() {
		return edge;
	}

	/*
	 * Union Find
	 */
	public int find(int[] parent, int i) {
		if(parent[i] == -1) {
			return i;
		}
		return find(parent, parent[i]);
	}
	public void union(int[] parent, int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}
	public boolena isCycle () {
		int[] parent = new int[V];
		for(int i = 0; i < V; i++) {
			parent[i] = -1;
		}
		for(int i = 0; i < E; i++) {
			int x = find(parent, edge[i].src);
			int y = find(parent, edge[i].dest);
			if(x == y) return true;
			union(parent, x, y);
		}
		return false;
	}
}