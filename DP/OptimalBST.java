/*
 * Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, where freq[i] is the number of searches to keys[i]. Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.

 * Let us first define the cost of a BST. The cost of a BST node is level of that node multiplied by its frequency. Level of root is 1.
 * Get the minimum total cost.
 */
public class OptimalBST {
	//time: exponential, each number can be selected as the root. O(2^n).
	public static int minCost(int[] freq) {
		return minCost(freq, 0, freq.length - 1);
	}
	public static int minCost(int[] freq, int start, int end) {
	    if(start == end) return freq[start];
	    if(start > end) return 0;
	    int sum = 0;
	    int minC = Integer.MAX_VALUE;
	    for(int i = start; i <= end; i++) {
	    	sum += freq[i];
	    	int cost = minCost(freq, start, i - 1) + minCost(freq, i + 1, end);
	    	minC = Math.min(minC,  cost);
	    }
	    return minC + sum;
	}
}
