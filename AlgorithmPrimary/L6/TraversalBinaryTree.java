package Lesson06;

public class TraversalBinaryTree {
	// 1. 创造节点
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int v) {
			value = v;
		}
	}
	
	// 2. 遍历
	public static void f(Node head) {
		if(head == null) {
			return;
		}
		// (1)
		f(head.left);
		// (2)
		f(head.right);
		// (3)
	}
	
	// 3. 先序打印所有节点
	public static void pre(Node head){
		if(head == null) {
			return;
		}
		System.out.println(head.value);
		pre(head.left);
		pre(head.right);
	}
	
	// 4. 中序打印所有节点
	public static void in(Node head) {
		if(head == null) {
			return;
		}
		pre(head.left);
		System.out.println(head.value);
		pre(head.right);
	}
	
	//5. 后序打印所有节点
	public static void pos(Node head) {
		if(head == null) {
			return;
		}
		pre(head.left);
		pre(head.right);
	}
	
	// 6. 测试
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
	    head.right = new Node(3);
	    head.left.left = new Node(4);
	    head.left.right = new Node(5);
	    head.right.left = new Node(6);
	    head.right.right = new Node(7);
	    
	    pre(head);
	    System.out.println("=======================");
	    in(head);
	    System.out.println("=======================");
	    pos(head);
	    System.out.println("=======================");
	}

}

// 可以从递归序推出先序、中序和后序序列






































