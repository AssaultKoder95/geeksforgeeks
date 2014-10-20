import java.util.*;
public class GraphCycle {
	int V;
	List<Integer>[] neighbors;
	public GraphCycle(int V) {
		this.V = V;
		neighbors = (List<Integer>[]) new ArrayList[V];
		for(int i = 0; i < V; i++) {
			neighbors[i] = new ArrayList<Integer> ();
		}
	}
	public void addEdge(int v, Integer num) {
		neighbors[v].add(num);
	}
	public boolean DAGDFS() {
		boolean[] visited = new boolean[V];
		boolean[] resStack = new boolean[V];
		for(int i = 0; i < neighbors.length; i++) {
			if(!visited[i]) {
				if(dag(i, visited, resStack)) return true;
			}
		}
		return false;
	}
	public boolean dag(int num, boolean[] visited, boolean[] resStack) {
		visited[num] = true;
		resStack[num] = true;

		for(int i : neighbors[num]) {
			if(!visited[i] && !resStack[i]) {
				if(dag(i, visited, resStack)) return true;
			}
			if(resStack[i]) {
				return true;
			}
		}
		resStack[num] = false;
		return false;
	}
	public boolean containCycleDFSNDAG() {
		boolean[] visited = new boolean[V];
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				if(dfsNotDirected(i, visited, -1)) return true;
			}
		}
		return false;
	}
	public boolean dfsNotDirected(int num, boolean[] visited, int parent) {
		visited[num] = true;
		for(int i : neighbors[num]) {
			if(!visited[i]) {
				if(dfsNotDirected(i, visited, num)) return true;
			}
			else {
				if(parent != i) return true;
			}
		}
		return false;
	}
	public boolean containCycleBFS() {
		boolean[] visited = new boolean[V];
		boolean[] upper = new boolean[V];
		List<Integer> list = new ArrayList<Integer> ();
		List<Integer> parent = new ArrayList<Integer> ();
		for(int i = 0; i < neighbors.length; i++) {
			if(!visited[i]) {
				list.add(i);
				while(list.size() != 0) {
					parent = list;
					list = new ArrayList<Integer> ();
					for(Integer p : parent) {
						if(upper[p]) {
							return true;
						}
						upper[p] = true;
					}
					while(parent.size() > 0) {
					    int num = parent.remove(0);
					    for(int j = 0; j < neighbors[num].size(); j++) {
			                if(!list.contains(neighbors[num].get(j))) {
			                	list.add(neighbors[num].get(j));
			    	        }
			    	    }
			    	    visited[num] = true;
			    	}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		GraphCycle gc = new GraphCycle(5);
		gc.addEdge(1, 0);
		gc.addEdge(0, 2);
		gc.addEdge(0, 3);
		gc.addEdge(3, 4);
		gc.addEdge(2, 4);
		System.out.println(gc.containCycleBFS());
		System.out.println(gc.DAGDFS());
		System.out.println(gc.containCycleDFSNDAG());
		GraphCycle gc2 = new GraphCycle(3);
		gc2.addEdge(0, 1);
		gc2.addEdge(1, 2);
		//gc2.addEdge(0, 2);
		System.out.println(gc2.containCycleBFS());
		System.out.println(gc2.DAGDFS());
		System.out.println(gc2.containCycleDFSNDAG());
		GraphCycle gc3 = new GraphCycle(5);
		gc3.addEdge(1, 0);
		gc3.addEdge(0, 2);
		gc3.addEdge(2, 0);
		gc3.addEdge(0, 3);
		gc3.addEdge(3, 4);
		System.out.println(gc3.containCycleBFS());
		System.out.println(gc3.DAGDFS());
		System.out.println(gc3.containCycleDFSNDAG());
		GraphCycle gc4 = new GraphCycle(5);
		gc4.addEdge(0, 4);
		gc4.addEdge(0, 1);
		gc4.addEdge(1, 2);
		gc4.addEdge(4, 1);
		System.out.println(gc4.containCycleBFS());
		System.out.println(gc4.DAGDFS());
		System.out.println(gc4.containCycleDFSNDAG());
	}
}