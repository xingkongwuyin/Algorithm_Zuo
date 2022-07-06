package lesson12;

public class Code02_IsBBT {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int v){
			this.value = v;
		}
		
		public static boolean isbBT(Node head) {
			if(head == null) {
				return true;
			}
			return process(head).isBalanced;
		}
		
		public static class Info{
			public boolean isBalanced;
			public int height;
			
			public Info(boolean i, int h) {
				isBalanced = i;
				height = h;
			}
		}
		
		public static Info process(Node x) {
			if(x == null) {
				return new Info(true, 0);
			}
			Info leftInfo = process(x.left);
			Info rightInfo = process(x.right);
			int height = Math.max(leftInfo.height, rightInfo.height) + 1;
			boolean isBalanced = false;
			int n = Math.abs(leftInfo.height - rightInfo.height);
			if(leftInfo.isBalanced 
					&& 
			   rightInfo.isBalanced
					&&
			   	n < 2) {
				isBalanced = true;
			}
			return new Info(isBalanced, height);
		}
	}
}
