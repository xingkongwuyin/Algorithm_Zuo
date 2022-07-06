package lesson12;

public class Code06_MaxSubBSTSize {
		
	public static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int v) {
			val = v;
		}
	}
	
	public static int maxSubBSTSize(TreeNode head) {
		if(head == null) {
			return 0;
		}
		return process(head).maxSubSize;
	}
	
	public static class Info{
		public int maxSubSize;
		public int allSize;
		public int max;
		public int min;
		
		public Info(int maxs, int all, int max, int min) {
			maxSubSize = maxs;
			allSize = all;
			this.max = max;
			this.min = min;
		}
	}
	
	public static Info process(TreeNode x) {
		if(x == null) {
			return null;
		}
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		
		int max = x.val;
		int min = x.val;
		int allSize = 1;
		if(leftInfo != null) {
			max = Math.max(max, leftInfo.max);
			min = Math.min(max, leftInfo.min);
			allSize += leftInfo.allSize;
		}
		if(rightInfo != null) {
			max = Math.max(max, rightInfo.max);
			min = Math.min(min, rightInfo.min);
			allSize += rightInfo.allSize;
		}
		
		int p1 = -1;
		if(leftInfo != null) {
			p1 = leftInfo.maxSubSize;
		}
		int p2 = -1;
		if(rightInfo != null) {
			p2 = rightInfo.maxSubSize;
		}
		int p3 = -1;
		boolean leftBST = leftInfo == null ? true : leftInfo.maxSubSize == leftInfo.allSize; 
		boolean rightBST = rightInfo == null ? true : rightInfo.maxSubSize == rightInfo.allSize;
		
		if(leftBST && rightBST) {
			boolean leftMin = leftInfo == null ? true :  leftInfo.max < x.val;
			boolean rightMax = rightInfo == null ? true : leftInfo.min > x.val;
			if(leftMin && rightMax) {
				int leftSize = leftInfo == null ? 0 : leftInfo.allSize;
				int rightSize = rightInfo == null ? 0 :rightInfo.allSize;
				p3 = leftSize + rightSize + 1;
			}
		}
		return new Info(Math.max(p1, Math.max(p2, p3)), allSize, max, min);
		
		
		        
				            		  
				       
	}
}


















