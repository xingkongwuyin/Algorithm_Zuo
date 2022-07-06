package lesson12;

public class Code03_isSBT {
	
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int x) {
			value = x;
		}
	}
	
	public static boolean isSBT(Node head) {
		if(head == null) {
			return true;
		}
		return process(head).isSBT;
	}
	
	public static class Info{
		
		public boolean isSBT;
		public int max;
		public int min;
		
		public Info(boolean b, int ma, int mi) {
			isSBT = b;
			max = ma;
			min = mi;
		}
		
	}
	
	public static Info process(Node x) {
		if(x == null) {
			return null;
		}
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		int max = x.value;
		int min = x.value;
		if(leftInfo != null) {
			max = Math.max(max, leftInfo.max);
			min = Math.min(min, leftInfo.min);
		}
		if(rightInfo != null) {
			max = Math.max(max, rightInfo.max);
			min = Math.min(min, rightInfo.min);
		}
		boolean isSBT = false;
		if(leftInfo == null && rightInfo == null) {
			isSBT = true;
		}
		if(leftInfo != null && rightInfo == null) {
			if(leftInfo.max < x.value) {
				isSBT = true;
			}
		}
		if(leftInfo == null && rightInfo != null) {
			if(rightInfo.min > x.value) {
				isSBT = true;
			}
		}
		if(leftInfo != null && rightInfo != null) {
			if(leftInfo.max < x.value 
					&&
			   rightInfo.min > x.value) {
				isSBT = true;
			}
		}
		return new Info(isSBT, max, min);
	}
	
}





















