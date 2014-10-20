public class IsomorphicTree {
	public static boolean isomorphic(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) {
			return true;
		}
		if(t1 == null || t2 == null) {
			return false;
		}
		if(t1.data != t2.data) {
			return false;
		}
		return (isomorphic(t1.left, t2.left) && isomorphic(t1.right, t2.right)) || (isomorphic(t1.left, t2.right) && isomorphic(t1.right, t2.left)));
	}
}