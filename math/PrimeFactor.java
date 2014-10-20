import java.util.*;
public class PrimeFactor{
	public static List<Integer> getPrime(int n) {
		List<Integer> list = new ArrayList<Integer> ();
		return getPrime(n, list);
	}
	public static List<Integer> getPrime(int n, List<Integer> list) {
		if(n % 2 == 0) {
			list.add(2);
			n /= 2;
			return getPrime(n, list);
		}
		for(int i = 3; i * i <= n; i+=2) {
			if(n % i == 0 && isPrime(i)) {
				list.add(i);
				n /= i;
				return getPrime(n, list);
			}
		}
		list.add(n);
		return list;
	}
	public static boolean isPrime(int n) {
		if(n == 2) return true;
		if(n == 1) return false;
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		List<Integer> list = getPrime(12);
		for(Integer i : list) {
			System.out.println(i);
		}
	}
}