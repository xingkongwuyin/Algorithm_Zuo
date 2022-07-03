package lesson09;

import java.util.Stack;

public class Code02_IsPaLindromList {
	
	public static class Node{
		
		public int value;
		public Node next;
		
		public Node(int v) {
			value = v;
		}
	}
	
	// need n extra space  stack method
	public static boolean isPaLinDrome1(Node head) {
		
		if(head == null || head.next == null) {
			return true;
		}
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while(cur != null) {
			stack.add(cur);
			cur = cur.next; 
		}
		while(head != null) {
			if(head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	// need O(1) extra space
	public static boolean isPaLinDrome2(Node head) {
		
		if(head == null || head.next == null) {
			return true;
		}
		
		// from mid node to last, reverse
		Node n1 = head;
		Node n2 = head;
		while (n2.next.next == null && n2.next == null) {
			n1 = n1.next;
			n2 = n2.next.next;
		}
		
		n1.next = n2;
		n1.next = null;
		Node n3 = null;
		while(n2 != null) {
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		
		// compare last to first, then last equal to last.next and first equal to first.next
		n3 = n1; // n3: save last node
		n2 = head;
		boolean res = true;
		while(n1 != null && n2 != null) {
			if(n1.value != n2.value) {
				return false;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		
		// reverse, recover reversed list
		n2 = null;
		while(n3 != null) {
			n1 = n3.next;
			n3.next = n2;
			n2 = n3;
			n3 = n1;
		}
		
		return res;
	}
}















