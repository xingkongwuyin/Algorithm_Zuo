package Lesson06;

public class SymmetricTree {

	// 1. 创建结点
	public static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
	}
	
	// 2. 判断是否镜像
	public static boolean isMirror(TreeNode h1, TreeNode h2) {
		if(h1 == null ^ h2 == null) {
			return false;
		}
		else if(h1 == null && h2 == null) {
			return true;
		}
		else {
			return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);
		}
	}
}
