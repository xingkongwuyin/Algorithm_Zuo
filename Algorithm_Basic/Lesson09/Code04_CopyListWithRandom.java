package lesson09;

import java.util.HashMap;

public class Code04_CopyListWithRandom {
	
	public static class Node{
		int val;
		Node next;
		Node random;
	
		public Node(int val) {
			this.val = val; 
		}
	}
	
	// First solution :HashMap
	public static Node copyRandomList1(Node head) {
		
		// key: old node
		// value: new node
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node cur = head;
		while(cur != null) {
			map.put(cur, new Node(cur.val));
			cur = cur.next;
		}
		cur = head;
		while(cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		return map.get(head);
	}
	
	// second solution 
	public static Node copyRandomList2(Node head) {
		
		if(head == null) {
			return null;
		}
		
		Node cur = null;
		Node next = null;
		while(cur != null) {
			next = cur.next;
			cur.next = new Node(cur.val);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		Node copy = null;
      	
		// 1 1' 2 2' 3 3' 
		// add random to new node
		while(cur != null) {
			next = cur.next.next;
			copy = cur.next;
			copy.random = cur.random != null ? cur.random.next : null;
			cur = next;
		}
		
		// recover
		Node res = head.next;
		cur = head;
		while(cur != null) {
			next = cur.next.next;
			copy = cur.next;
			cur.next = next;
			copy.next = next != null ? next.next : null;
			cur = next;
		}
		return res;
		
		

	}
	
	
	
}














