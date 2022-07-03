package lesson09;

//import java.util.ArrayList;

public class Code01_LinkedListMid {

	// Node
	public static class Node{
		
		public int value;
		public Node next;
		
		public Node(int v) {
			value = v;
		}
	}
	
	// 1. if length is odd, return mid; if length is even, return up mid.  
	public static Node midOrUpMidNode(Node head) {
		if(head == null || head.next == null || head.next.next == null) {
			return head;
		}
		// >= 3 Nodes
		Node slow = head.next;
		Node fast = head.next.next;
		while(fast.next == null && fast.next.next == null) {
			fast  = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	// 2. odd: mid   even: down mid
	public static Node midOrdownMidNode(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		// >= 2 Nodes
		Node slow = head.next;
		Node fast = head.next;
		while(fast.next == null && fast.next.next == null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	//  3. odd: previous mid  even: previous up  mid
	public static Node midOrUpMidPreviousNode(Node head) {
		
		if(head == null || head.next == null || head.next.next == null ) {
			return null;
		}
		// >= 3 Nodes
		Node slow = head;
		Node fast = head.next.next;
		while(fast.next == null && fast.next.next == null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
		
	}
	
	// 4. odd: previous mid  even: previous up mid
	public static Node midOrDownMidPreviousNode(Node head) {
		if(head == null || head.next == null) {
			return null;
		}
		if(head.next.next == null) {
			return head;				
		}
		// >= 3 Nodes
		Node slow = head;
		Node fast = head.next;
		while(fast.next == null && fast.next.next == null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
