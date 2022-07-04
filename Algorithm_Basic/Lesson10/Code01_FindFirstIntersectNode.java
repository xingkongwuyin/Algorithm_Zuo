package lesson10;

public class Code01_FindFirstIntersectNode {
	
	public static class Node{
		public int value;
		public Node next;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	// to find intersect node between two node.
	public static Node getIntersectNode(Node head1, Node head2) {
		
		if(head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if(loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if(loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}
	
	// to find the first entry point of linked list.
	public static Node getLoopNode(Node head) {
		
		if(head ==null || head.next == null || head.next.next == null) {
			return null;
		}
		// why slow is from head.next
		Node slow = head.next;
		Node fast = head.next.next;
		while(slow != fast) {
			if(fast.next == null || fast.next.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = head;
		while(slow != fast) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;	
	}
	
	// returns the first intersecting node if the two ring-free linked
	// lists intersect, or null if they don't intersect
	public static Node noLoop(Node head1, Node head2) {
		
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;
		while(cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while(cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if(cur1 != cur2) {
			return null;
		}
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
		while(n != 0) {
			cur1 = cur1.next;
		}
		while(cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
	// return the first intersecting node if two ringed linked list intersects, 
	// or null, if they don't intersect.
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if(loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while(cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while(cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while(n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while(cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return 	cur1;	
		}else {
			cur1 = loop1.next;
			while(cur1 != loop1) {
				if(cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
		}
	return cur1;
				
	}
	
}





















