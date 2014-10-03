//nearly sorted algorithm
//sort a nearly sorted(or k sorted) array
//Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. 
//For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.

//O(N log K)
import java.util.PriorityQueue;
import java.util.Comparator;

public class nearlySorted {
	public static void insertionSort(int[] array, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer> (k, new Comparator<Integer> () {
			public int compare(Integer a, Integer b) {
				return a > b? 1 : (a == b ? 0 : -1);
			}
		});
		int i = 0;
		for(int num : array) {
			if(minHeap.size() < k) {
				minHeap.offer(num);
			}
			else {
				if(num > minHeap.peek()) {
					array[i++] = minHeap.poll();
					minHeap.offer(num);
				}
				else {
					array[i++] = num;
				}
			}
		}
		while(minHeap.size() > 0) {
			array[i++] = minHeap.poll();
		}
	}
	public static void main(String[] args) {
		int[] array = {1,2,5,4,3,9,6,7,5};
		insertionSort(array, 3);
		for(int i : array)
			System.out.println(i);
	}
}