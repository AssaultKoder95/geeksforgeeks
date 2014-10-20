import java.util.*;
public class Prime {
	public static List<Integer> prime(int n) {
		boolean[] array = new boolean[n];
		int count = 2;
		while(count < array.length) {
			int i = 2;
			while(count * i <= array.length) {
				array[count * i - 1] = true;
				i++;
			}
			count++;
			while(count <= array.length && array[count - 1]) {
				count++;
			}
		}
		List<Integer> list = new ArrayList<Integer> ();
		for(int i = 0; i < array.length; i++) {
			if(!array[i]) {
				list.add(i + 1);
			}
		}
		return list;
	}
	public static void main(String[] args) {
		List<Integer> list = prime(100);
		for(Integer i : list) {
			System.out.println(i);
		}
	}
}