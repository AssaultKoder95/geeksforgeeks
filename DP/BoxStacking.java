/*
 * You are given a set of n types of rectangular 3-D boxes, where the i^th box has height h(i), width w(i) and depth d(i) (all real numbers). You want to create a stack of boxes which is as tall as possible, but you can only stack a box on top of another box if the dimensions of the 2-D base of the lower box are each strictly larger than those of the 2-D base of the higher box. Of course, you can rotate a box so that any side functions as its base. It is also allowable to use multiple instances of the same type of box.
 * 1) A box can be placed on top of another box only if both width and depth of the upper placed box are smaller than width and depth of the lower box respectively.
 * 2) We can rotate boxes. For example, if there is a box with dimensions {1x2x3} where 1 is height, 2×3 is base, then there can be three possibilities, {1x2x3}, {2x1x3} and {3x1x2}.
 * 3) We can use multiple instances of boxes. What it means is, we can have two different rotations of a box as part of our maximum height stack.
 * 1) Generate all 3 rotations of all boxes. The size of rotation array becomes 3 times the size of original array. For simplicity, we consider depth as always smaller than or equal to width.

 * 2) Sort the above generated 3n boxes in decreasing order of base area.

 * 3) After sorting the boxes, the problem is same as LIS with following optimal substructure property.
      MSH(i) = Maximum possible Stack Height with box i at top of stack
      MSH(i) = { Max ( MSH(j) ) + height(i) } where j < i and width(j) > width(i) and depth(j) > depth(i).
      If there is no such j then MSH(i) = height(i)

 * 4) To get overall maximum height, we return max(MSH(i)) where 0 < i < n
 */
import java.util.Arrays;
import java.util.Comparator;

public class BoxStacking {
	public static int getHeight(Integer[][] boxes) {
		if(boxes.length == 0) return 0;
		Integer[][] moreboxes = new Integer[boxes.length * 3][boxes[0].length];
		int count = 0;
		for(int i = 0; i < boxes.length; i++) {
			moreboxes[count++] = boxes[i];
			Integer[] more = new Integer[3];
			more[0] = boxes[i][1];
			more[1] = boxes[i][2];
			more[2] = boxes[i][0];
			moreboxes[count++] = more;
			Integer[] more2 = new Integer[3];
			more2[0] = boxes[i][2];
			more2[1] = boxes[i][0];
			more2[2] = boxes[i][1];
			moreboxes[count++] = more2;
		}
		Arrays.sort(moreboxes, new Comparator<Integer[]> () {
			public int compare(Integer[] a, Integer[] b) {
				if(a[1] * a[2] > b[1] * b[2]) {
					return 1;
				}
				if(a[1] * a[2] == b[1] * b[2]) {
					return 0;
				}
				return -1;
			}
		});
		int[] height = new int[moreboxes.length];
		int max = height[0];
		for(int i = 0; i < moreboxes.length; i++) {
			for(int j = 0; j < i; j++) {
				if(moreboxes[j][1] < moreboxes[i][1] && moreboxes[j][2] < moreboxes[i][2]) {
					height[i] = Math.max(height[i], height[j]);
				}
			}
			height[i] += moreboxes[i][0];
			max = Math.max(max, height[i]);
		}
		return max;
	}
}
