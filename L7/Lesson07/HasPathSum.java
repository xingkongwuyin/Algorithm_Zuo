package Lesson07;

// 在给定一个二叉树和一个key，是否该二叉树某条路径的和等于key
public class HasPathSum {
	
	// 1. 创造结点
	public static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public static boolean isSum = false;
	
	// 2. hasPathSum
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		isSum = false;
		process(root, 0, sum);
		return isSum;
	}
	
	// 3. process
	public static void process(TreeNode x, int preSum, int sum) {
		if(x.left == null && x.right == null) {
			if((preSum + x.val) == sum) {
				isSum = true;
			}
			return;
		}
		preSum += x.val;

		if(x.left  != null) {
			process(x.left, preSum, sum);
		}
		if(x.right != null) {
			process(x.right, preSum, sum);
		}
	}

	
	// 4. 判断
	public static boolean hasPathSum1(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		return isSum;
	}
	
	
	
	

}
