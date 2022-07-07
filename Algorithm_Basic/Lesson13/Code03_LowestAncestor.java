package lesson13;

public class Code03_LowestAncestor {
	
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int v) {
			value = v;
		}
	}
	
	public static Node lowestAncestor(Node head, Node a, Node b) {
		if(head == null) {
			return null;
		}
		return process(head, a, b).ans;
	}
	
	public static class Info{
		public boolean findA;
		public boolean findB;
		public Node ans;
		
		public Info(boolean A, boolean B, Node a) {
			findA = A;
			findB = B;
			ans = a;
		}
	}
	
	public static Info process(Node x, Node a, Node b) {
		if(x == null) {
			return new Info(false, false, null);
		}
		Info leftInfo = process(x.left, a, b);
		Info rightInfo = process(x.right,a,b);
		boolean findA = (x == a) || leftInfo.findA || rightInfo.findA ? true : false;
		boolean findB = (x == b) || leftInfo.findB || rightInfo.findB ? true : false;
		Node ans = null;
		if(leftInfo.ans != null) {
			ans = leftInfo.ans;
		}
		if(rightInfo.ans != null) {
			ans = rightInfo.ans;
		}
		if(findA && findB) {
			ans = x;
		}
		return new Info(findA, findB, ans);
	}
	
}













