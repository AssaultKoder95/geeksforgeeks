/*
 * We are given an array of n points in the plane, and the problem is to find out the closest pair of points in the array. 
 */
import java.util.*;
public class closePairs {
	public static int close(Integer[][] array) {
		Arrays.sort(array, new Comparator<Integer[]> () {
			public int compare(Integer[] a, Integer[] b) {
				return a[0] > b[0]? 1 : (a[0] == b[0]? 0 : -1);
			}
		});
		return close(array, 0, array.length - 1);
	}
	public static Integer close(Integer[][] array, int start, int end) {
		if(end - start <= 2) return bf(array, start, end);
		int middle = start + (end - start) / 2;
		int left = close(array, start, middle);
		int right = close(array, middle + 1, end);
		Integer[] mid = array[middle];
		int dis = Math.min(left, right);
		Integer[][] helper = new Integer[array.length][array[0].length];
		int count = 0;
		for(int i = start; i <= end; i++) {
			if(distance(array[i], mid) < dis) {
				helper[count++] = array[i];
			}
		}
		return Math.min(dis, close(helper, 0, count - 1));
	}
	public static int distance(Integer[] pointa, Integer[] pointb) {
		return (int) (Math.pow(pointa[0] - pointb[0], 2) + Math.pow(pointa[1] - pointb[1],	2));
	}
	public static int bf(Integer[][] array, int start, int end) {
		int min = Integer.MAX_VALUE;
		for(int i = start; i < end; i++) {
			for(int j = i + 1; j <= end; j++) {
				min = Math.min(distance(array[i], array[j]), min);
			}
		}
		return min;
	}
	public static void main(String[] args) {
		Integer[][] array = {{1,3},{2,2},{5,4},{5,6}};
		System.out.println(close(array));
	}
}
