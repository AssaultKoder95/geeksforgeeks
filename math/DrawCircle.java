public class DrawCircle {
	public static void draw(int r) {
		int N = 2 * r;
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= N; j++) {
				int x = i - r;
				int y = j - r;
				if(x * x + y * y <= r * r) {
					System.out.print(".");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		draw(8);
	}
}