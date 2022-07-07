package lesson13;

public class Code01_IsCBT {
	
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int v) {
			value = v;
		}
	}
	public static boolean isCompleteBT(Node head) {
		if(head == null) {
			return true;
		}
		return process(head).isCBT;
	}
	
	public static class Info{
		public boolean isCBT;
		public boolean isFull;
		public int height;
		
		public Info(boolean c, boolean f, int h) {
			isCBT = c;
			isFull = f;
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
		boolean isFull = leftInfo.isFull 
						 && 
						 rightInfo.isFull
						 && 
						 rightInfo.height == leftInfo.height;
		boolean isCBT = false;
		if(isFull) {
			isCBT = true;
		}else if(leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1){
			isCBT = true;
		}else if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
			isCBT = true;
		}else if(leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height) {
			isCBT = true;}
		return new Info(isCBT, isFull, height);
	}


}
