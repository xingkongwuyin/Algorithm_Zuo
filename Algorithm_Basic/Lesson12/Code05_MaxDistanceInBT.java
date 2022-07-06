package lesson12;

public class Code05_MaxDistanceInBT {
	
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int v) {
			value = v;
		}
	}
	
	public static int maxDistanceInBT(Node head) {
		if(head == null) {
			return 0;
		}
		return process(head).maxDistance;
	}
	
	public static class Info{
		public int maxDistance;
		public int height;
		
		public Info(int max, int h) {
			maxDistance = max;
			height = h;
		}
	}

	public static Info process(Node x) {
		if(x == null) {
			return new Info(0, 0);
		}
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		
		int maxDistance = leftInfo.height + rightInfo.height + 1;
		maxDistance = Math.max(maxDistance, Math.max(leftInfo.height, rightInfo.height));
		return new Info(maxDistance, height);
	}
	
}























