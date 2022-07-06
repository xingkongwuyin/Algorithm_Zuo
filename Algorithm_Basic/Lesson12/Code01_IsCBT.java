package lesson12;

public class Code01_IsCBT {

	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public  Node(int data) {
			value = data;
		}
	}
	
	public static boolean isBCT(Node head) {
		if(head == null) {
			return true;
		}
		return process(head).isCBT;
	}
	
	public static class Info{
		public boolean isFull;
		public boolean isCBT;
		public int height;
		
		public Info(boolean full, boolean cbt, int h) {
			isFull = full;
			isCBT = cbt;
			height = h;
		}
	}
	
	public static Info process(Node x) {
		
		if(x == null) {
			return new Info(true, true, 0);
		}
		
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		boolean isfull = leftInfo.isFull 
				&& 
				rightInfo.isFull 
				&& 
				leftInfo.height == rightInfo.height;
		boolean isCBT = false;
		if(isfull) {
			isCBT = true;
		}
		if(leftInfo.isCBT && rightInfo.isCBT) {
			if(leftInfo.isFull 
			   &&
			   rightInfo.isFull
			   && 
			   leftInfo.height == rightInfo.height + 1) {
				isCBT = true;
			}
			if(leftInfo.isFull 
			   && 
			   rightInfo.isCBT
			   && 
			   leftInfo.height == rightInfo.height) {
				isCBT = true;
			}
			if(leftInfo.isCBT
			   && 
			   rightInfo.isFull
			   &&
			   leftInfo.height == rightInfo.height + 1) {
				isCBT = true;
			}
		}
		return new Info(isfull, isCBT, height);
	}
}





















