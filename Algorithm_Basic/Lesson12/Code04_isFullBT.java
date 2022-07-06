package lesson12;

public class Code04_isFullBT {
	
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int v) {
			value = v;
		}
	}
	public static boolean isFull(Node head) {
		if(head == null) {
			return true;
		}
		return process(head).isFull;
	}
	
	public static class Info{
		public int height;
		public boolean isFull;
		
		public Info(int h, boolean f) {
			height = h;
			isFull = f;
		}
	}
	
	public static Info process(Node x) {
		if(x == null) {
			return new Info(0, true);
		}
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		int height = Math.max(leftInfo.height, rightInfo.height);
		boolean isFull = false;
		if(leftInfo.isFull 
			&& 
		   rightInfo.isFull 
			&& 
		   leftInfo.height == rightInfo.height) {
		   isFull = true;
		}
		return new Info(height, isFull);
	}
}
























