/*
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. 
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.
 */
public class longestCommonSeq {
	public static int common(String s1, String s2) {
		if(s1.length() == 0 || s2.length() == 0) return 0;
		int[][] memory = new int[s1.length()][s2.length()];
		memory[0][0] = s1.charAt(0) == s2.charAt(0)? 1 : 0;
		int max = 0;
		for(int i = 1; i < s1.length(); i++) {
			memory[i][0] = (Integer) (s1.charAt(i) == s2.charAt(0)? Math.max(memory[i - 1][0], 1) : memory[i - 1][0]);
			max = Math.max(max, memory[i][0]);
		}
		for(int i = 1; i < s2.length(); i++) {
			memory[0][i] = (Integer) (s1.charAt(0) == s2.charAt(i)? Math.max(memory[0][i - 1], 1) : memory[i - 1][0]);
			max = Math.max(max, memory[0][i]);
		}
		for(int i = 1; i < memory.length; i++) {
			for(int j = 1; j < memory[i].length; j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					memory[i][j] = memory[i - 1][j - 1] + 1;
				}
				else {
					memory[i][j] = Math.max(memory[i - 1][j], memory[i][j - 1]);
				}
				max = Math.max(max, memory[i][j]);
			}
		}
		return max;
	}
}
