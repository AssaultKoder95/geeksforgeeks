import java.util.Stack;
public class SumBST {
	/*
	 *Given a Balanced Binary Search Tree and a target sum, write a function that returns true if there is a pair with sum equals to target sum, otherwise return false. Expected time complexity is O(n) and only O(Logn) extra space can be used. 
     */
	public int[] getSum(TreeNode root, int sum) {
		Stack<TreeNode> inorder = new Stack<TreeNode>();
		Stack<TreeNode> reverse = new Stack<TreeNode> ();
		TreeNode[] p1 = {root}, p2 = {root};
		int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
		while((left == Integer.MIN_VALUE && right == Integer.MAX_VALUE) || (left + right != sum && left != right)) {
			if(left == Integer.MIN_VALUE || left + right < sum) {
				left = moveLeft(inorder, p1);
			}
			if(right == Integer.MAX_VALUE || left + right > sum) {
				right = moveRight(reverse, p2);
			}
			if(left + right == sum) {
				int[] res = {left, right};
				return res;
			}
		}
		return null;
	}
	public int moveLeft(Stack<TreeNode> inorder, TreeNode[] p1) {
		while(p1[0] != null || !inorder.isEmpty()) {
			if(p1[0] != null) {
				inorder.push(p1[0]);
				p1[0] = p1[0].left;
			}
			else {
				TreeNode n = inorder.pop();
				p1[0] = n.right;
				int left = n.data;
				return left;
			}
		}
		return 0;
	}
	public int moveRight(Stack<TreeNode> reverse, TreeNode[] p2) {
		while(p2[0] != null || !reverse.isEmpty()) {
			if(p2[0] != null) {
				reverse.push(p2[0]);
				p2[0] = p2[0].right;
			}
			else {
				TreeNode n = reverse.pop();
				p2[0] = n.left;
				int right = n.data;
				return right;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		SumBST sb = new SumBST();
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(16);
		root.right.right = new TreeNode(25);
		int[] array = sb.getSum(root, 36);
		System.out.println(array[0] + " " + array[1]);
	}
}