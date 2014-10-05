import java.util.*;
/*
 * The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. 
 * For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class longIncrease {
	public static List<Integer> findIncrease(int[] array) {
		List<Integer> list = new ArrayList<Integer> ();
		@SuppressWarnings("unchecked")
		List<Integer>[] mem = (ArrayList<Integer>[]) new ArrayList[array.length];
		int max = 1;
		if(array.length == 0) return list;
		for(int i = 0; i < mem.length; i++) {
			mem[i] = new ArrayList<Integer> ();
			mem[i].add(array[i]);
		}
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < i; j++) {
				if(array[j] < array[i] && mem[j].size() + 1 > mem[i].size()) {
					mem[i] = new ArrayList<Integer> ();
					for(Integer num : mem[j]) {
						mem[i].add(num);
					}
					mem[i].add(array[i]);
				}
			}
			if(mem[i].size() > max) {
				max = mem[i].size();
				list = mem[i];
			}
		}
		return list;
	}
	public static void main(String[] args) {
		int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		for(Integer i : findIncrease(array))
		    System.out.println(i);
	}
}