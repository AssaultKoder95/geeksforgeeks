public class SameBST {
	public static boolean check(int[] array1, int[] array2) {
		TreeNode root = null;
		if(array1.length != array2.length) {
			return false;
		}
		return check(array1, array2, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, array1[0]);
	}
	public static boolean check(int[] array1, int[] array2, int min, int max, int index, int prev) {
		TreeNode root = null;
		while(index < array1.length) {
		    if(array1[index] > min && array1[index] < max) {
			    root = new TreeNode(array1[index]);
			    root.left = check(array1, array2, min, array1[index], index + 1, array1[index]);
			    root.right = check(array1, array2, array1[index], max, index + 1, array1[index]);
			    break;
		    }
		    else index++;
	    }
	    boolean b1 = false, b2 = false;
	    for(int i = 0; i < array2.length; i++) {
	    	if(array2[i] == root.left.val) {
	    		b1 = true;
	    	}
	    	if(array2[i] == root.right.val) {
	    		b2 = true;
	    	}
	    	if(array2[i] == prev && (b1 || b2)) {
	    		return false;
	    	}
	    	if(b1 && b2) {
	    		return true;
	    	}
	    }
		return true;
	}
	
	public static void main(String[] args) {
		int[] array1 = {8, 3, 6, 1, 4, 7, 10, 14, 13};
		int[] array2 = {8, 10, 14, 3, 6, 4, 1, 7, 13};
		System.out.println(check(array1, array2));
	}
}