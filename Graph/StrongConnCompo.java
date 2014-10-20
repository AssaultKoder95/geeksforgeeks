import java.util.*;

public class StrongConnCompo {
	int V;
	List<Integer> [] edges = null;
	public StrongConnCompo(int V) {
		this.V = V;
		edges = (LinkedList<Integer>[]) new LinkedList[V];
		for(int i = 0; i < V; i++) {
			edges[i] = new LinkedList<Integer> ();
		}
	}
	public void addEdge(int v, int w) {
		edges[v].add(w);
	}
	public void printSCC () {
		Stack<Integer> stack = new Stack<Integer> ();
		boolean[] visited = new boolean[V];
		for(int i = 0; i < V; i++){
			if(!visited[i]) {
				dfs(i, visited, stack);
			}
		}
		transpose();
		visited = new boolean[V];
		while(!stack.isEmpty()) {
			int v = stack.pop();
			if(!visited[v]) {
				dfs(v, visited);
				System.out.println();
			}
		}
	}
	public void dfs(int num, boolean[] visited, Stack<Integer> stack) {
		visited[num] = true;
		for(int i : edges[num]) {
			if(!visited[i]) {
				dfs(i, visited, stack);
			}
		}
		stack.push(num);
	}
	public void dfs(int num, boolean[] visited) {
		visited[num] = true;
	    System.out.println(num);
		for(int i : edges[num]) {
			if(!visited[i]) {
				dfs(i, visited);
			}
		}
	}
	public void transpose() {
		List<Integer> [] newedges = (LinkedList<Integer>[]) new LinkedList[V];
		for(int i = 0; i < V; i++) {
			newedges[i] = new LinkedList<Integer> ();
		}
		for(int i = 0; i < V; i++) {
			List<Integer> edge = edges[i];
			for(Integer num : edge) {
				newedges[num].add(i);
			}
		}
		edges = newedges;
	}
	public static void main(String[] args) {
		StrongConnCompo g = new StrongConnCompo(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.printSCC();
	}
}