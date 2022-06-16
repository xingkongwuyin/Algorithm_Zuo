package Lesson06;

public class MaxDepth {
	public static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
	}
	
	public static int maxDepth(TreeNode root){
		if(root == null) {
			return 0;
		}
		else {
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		}
	}

}
