import java.util.*;
public class NumberMultiply {
	/*
	 * Given a number ‘n’, find the smallest number ‘p’ such that if we multiply all digits of ‘p’, we get ‘n’. The result ‘p’ should have minimum two digits.
	 */
	public static int small(int n) {
		if(n < 10) {
			return 10 + n;
		}
		List<Integer> list = new ArrayList<Integer> ();
		for(int i = 9; i > 1; i--) {
			while(n % i == 0) {
				list.add(0, i);
				n /= i;
			}
		}
		int num = 0;
		if(n > 10) return -1;
		for(Integer nn : list) {
			num *= 10;
			num += nn;
		}
		return num;
	}
	public static void main(String[] args) {
		System.out.println(small(7));
		System.out.println(small(36));
		System.out.println(small(13));
		System.out.println(small(100));
	}
}