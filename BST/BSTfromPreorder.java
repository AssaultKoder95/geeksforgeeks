public class BSTfromPreorder {
	//Given preorder traversal of a binary search tree, construct the BST.
	public static TreeNode construct(int[] array) {
		return construct(array, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
	}
	public static TreeNode construct(int[] array, int min, int max, int index) {
		TreeNode root = null;
		while(index < array.length) {
		    if(array[index] > min && array[index] < max) {
			    root = new TreeNode(array[index]);
			    root.left = construct(array, min, array[index], index + 1);
			    root.right = construct(array, array[index], max, index + 1);
			    break;
		    }
		    else index++;
	    }
		return root;
	}
	public static void main(String[] args) {
		int[] array = {10, 5, 1, 7, 40, 50};
		TreeNode n = construct(array);
		System.out.println(n.data + " " + n.left.data + " " + n.right.data + " " + n.left.left.data + " " + n.left.right.data + " " + n.right.right.data);
	}
}