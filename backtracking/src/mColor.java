public class mColor {
	public static boolean color(int[][] graph, int m) {
		int[] colors = new int[graph.length];
		boolean b = color(graph, m, colors, 0);
		for(int i : colors) {
			System.out.println(i);
		}
		return b;
	}
	public static boolean color(int[][] graph, int m, int[] colors, int index) {
		if(index == colors.length) {
			return true;
		}
		for(int i = 1; i <= m; i++) {
			if(valid(graph, i, colors, index)) {
				colors[index] = i;
				if(color(graph, m, colors, index+1)) return true;
			}
		}
		return false;
	}
	public static boolean valid(int[][] graph, int num, int[] colors, int index) {
		for(int i = 0; i < graph.length; i++) {
			if(graph[index][i] == 1 && colors[i] == num) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int[][] graph = {{0,1,1,1},{1,0,1,0},{1,1,0,1},{1,0,1,0}};
		System.out.println(color(graph, 3));
	}
}
