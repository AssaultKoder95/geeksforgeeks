public class Excel {
	public static String transfer(int num) {
		String s = "";
		while(num > 0) {
			int n = num % 26;
			if(n == 0) {
				s = 'Z' + s;
				num = num / 26 - 1;
			}
			else {
				s = (char)('A' + n - 1) + s;
				num /= 26;
			}
		}
		return s;
	}
	public static void main(String[] args) {
		System.out.println(transfer(26));
		System.out.println(transfer(51));
		System.out.println(transfer(52));
		System.out.println(transfer(80));
		System.out.println(transfer(676));
		System.out.println(transfer(702));
		System.out.println(transfer(705));
	}
}