package Lesson07;

// 给定一个二叉树，判断是否为搜索二叉树
public class IsSearchBinaryTree {
 
    // 1. 创建结点	
	public static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}
	
	// 2. 创建Info
	public static class Info{
		public boolean isBST;
		public int max;
		public int min;
		
		public Info(boolean is, int ma, int mi) {
			isBST = is;
			max = ma;
			min = mi;
		}
	}
	
	// 3. 判断
	public Info process(TreeNode x) {
		if(x == null) {
			return null;
		}
		
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		int max = x.val;
		int min = x.val;
		if(leftInfo != null) {
			max = Math.max(max, leftInfo.max);
			min = Math.min(min, leftInfo.min); 
		}
		if(rightInfo != null) {
			max = Math.max(max, rightInfo.max);
			min = Math.max(min, rightInfo.min);
		}
		
		boolean isBST = false;
		boolean leftIsBST = leftInfo == null ? true : leftInfo.isBST;
		boolean rightIsBST = rightInfo == null ? true : leftInfo.isBST;
		boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
		boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
		
		if(leftIsBST && rightIsBST && leftMaxLessX && rightMinMoreX ) {
			 isBST = true;
		}
		return new Info(isBST, max, min);
	}
}























