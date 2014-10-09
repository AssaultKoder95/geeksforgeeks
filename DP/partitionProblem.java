/*
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
 */
import java.util.*;
public class partitionProblem {
	public static List<Integer> partition(int[] array) {
		List<Integer> list = new ArrayList<Integer> ();
		List<Integer> result = new ArrayList<Integer> ();
		int sum = 0;
		for(int i : array) {
			sum += i;
		}
		if(sum % 2 != 0) {
			return list;
		}
		else {
			getList(array, list, 0, sum / 2, result);
			return result;
		}
	}
	public static boolean getList(int[] array, List<Integer> list, int index, int target, List<Integer> result) {
		int sum = 0;
		for(int i = 0; i < index; i++) {
			sum += list.get(i);
		}
		if(sum == target) {
			for(int k = 0; k < index; k++) {
				result.add(list.get(k));
			}
			return true;
		}
		if(sum > target) return false;
		for(int i = index; i < array.length; i++) {
			list.add(index, array[i]);
			if(getList(array, list, index+1, target, result)) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int[] array = {1,5,11,5};
		List<Integer> list = partition(array);
		for(int i : list) {
			System.out.println(i);
		}
	}
}
