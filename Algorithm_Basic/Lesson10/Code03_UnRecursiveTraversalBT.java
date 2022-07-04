package lesson10;

import java.util.Stack;

public class Code03_UnRecursiveTraversalBT {
	
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int v) {
			value = v;
		}
	}
	
	// preface 
	public static void pre(Node head) {
		System.out.println("pre-order");
		if(head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			while(!stack.isEmpty()) {
				head = stack.pop();
				System.out.println(head.value + " ");
				if(head.right != null) {
					stack.push(head.right);
				}
				if(head.left != null) {
					stack.push(head.left);
				}
 			}
		}
		System.out.println();
	}
	
	// mid
	public static void mid(Node cur) {
		System.out.println("mid-order");
		if(cur != null) {
			Stack<Node> stack = new Stack<Node>();
			while(!stack.isEmpty() || cur != null) {
				if(cur != null) {
					stack.push(cur);
					cur = cur.left;
				}else {
					cur = stack.pop();
					System.out.print(cur.value + " ");
					cur = cur.right;
				}
			}
		}
		System.out.println();
	}
	
	// post
	public static void pos(Node head) {
		System.out.println("in-order");
		if(head != null) {
			Stack<Node> stack1 = new Stack<Node>();
			Stack<Node> stack2 = new Stack<Node>();
			stack1.push(head);
			while(!stack1.isEmpty()) {
				head = stack1.pop();
				stack1.push(head);
				if(head.left != null) {
					stack1.push(head.left);
				}
				if(head.right != head.right) {
					stack2.push(head.right);
				}
			}
			while(!stack2.isEmpty()) {
				head = stack2.pop();
				System.out.print( head.value + " ");
			}
 		}
	}
	
}






















