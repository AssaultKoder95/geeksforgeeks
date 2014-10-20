public class MaxSubtree {
	static int max = 0;
	public static int maxbst(TreeNode root) {
		if(root == null) return 0;
		int left = maxbst(root.left);
		int right = maxbst(root.right);
		max = Math.max(max, Math.max(left, right));
		if(getLeft(root) < root.data && root.data < getRight(root)) {
			max = Math.max(max, left + right + 1);
			return left + right + 1;
		}
		else return 1;
	}
	public static int getLeft(TreeNode root) {
		if(root == null || root.left == null) {
			return Integer.MIN_VALUE;
		}
		root = root.left;
		int val = root.data;
		while(root.right != null) {
			root = root.right;
			val = root.data;
		}
		return val;
	}
	public static int getRight(TreeNode root) {
		if(root == null || root.right == null) {
			return Integer.MIN_VALUE;
		}
		root = root.right;
		int val = root.data;
		while(root.left != null) {
			root = root.left;
			val = root.data;
		}
		return val;
	}
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(4);
		t1.left.left = new TreeNode(1);
		t1.left.right = new TreeNode(3);
		maxbst(t1);
		System.out.println(max);
		max = 0;
		TreeNode t2 = new TreeNode(50);
		t2.left = new TreeNode(30);
		t2.right = new TreeNode(60);
		t2.left.left = new TreeNode(5);
		t2.left.right = new TreeNode(20);
		t2.right.left = new TreeNode(45);
		t2.right.right = new TreeNode(70);
		t2.right.right.left = new TreeNode(65);
		t2.right.right.right = new TreeNode(80);
		maxbst(t2);
		System.out.println(max);
	}
}