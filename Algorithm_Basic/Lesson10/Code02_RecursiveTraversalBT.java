package lesson10;

public class Code02_RecursiveTraversalBT {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int v) {
			value = v;
		}
	}
	
	public static void f(Node head) {
		if(head == null) {
			return;
		}
		// 1 
		f(head.left);
		// 2
		f(head.right);
		// 3
	}
	
	// preface-orderly traverse all the nodes
	public static void pre(Node head) {
		if(head == null) {
			return;
		}
		System.out.println(head.value);
		pre(head.left);
		pre(head.right);
	}
	
	// mid-orderly traverse all the nodes
	public static void mid(Node head) {
		if(head == null) {
			return;
		}
		pre(head.left);
		System.out.println(head.value);
		pre(head.right);
	}
	
	// post-orderly traverse all the nodes
	public static void post(Node head) {
		if(head == null) {
			return;
		}
		pre(head.left);
		pre(head.right);
		System.out.println(head.value);
	}
	
}
