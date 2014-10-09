/*
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
 * For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 */
public class CuttingRod {
	public static int maxValueInCutting(int[] value) {
		int[] output = new int[value.length + 1];
		for(int index = 0; index < value.length; index++) {
			int max = 0;
			for(int i = 0; i <= index; i++) {
				if(output[i] + value[index - i] > max) {
					max = output[i] + value[index - i];
				}
			}
			output[index + 1] = max;
		}
		return output[value.length];
	}
}
