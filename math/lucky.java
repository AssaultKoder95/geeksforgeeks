public class lucky {
	public static boolean isLucky(int num) {
		return isLucky(num, 2);
	}
	public static boolean isLucky(int num, int count) {
		if(num < count) return true;
		if(num % count == 0) return false;
		num -= num / count;
		return isLucky(num, count+1);
	}
	public static void main(String[] args) {
		System.out.println(isLucky(19));
		System.out.println(isLucky(10));
		System.out.println(isLucky(7));
		System.out.println(isLucky(6));
	}
}