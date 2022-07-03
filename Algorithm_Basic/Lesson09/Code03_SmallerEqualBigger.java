package lesson09;

public class Code03_SmallerEqualBigger {
	
	public static class Node{
		public int value;
		public Node next;
		
		public Node(int v) {
			value = v;
		}
		
	}
	// array method
	public static Node ListPartition1(Node head, int pivot) {
		
		if(head == null) {
			return null;
		}
		int i = 0;
		Node cur = head;
		while(cur != null) {
			i++;
			cur = cur.next;
		}
		cur = head;
		Node[] nodes = new Node[i];
		for(i = 0; i < nodes.length; i++) {
			nodes[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodes, pivot);
		for(i = 1; i < nodes.length; i++) {
			nodes[i - 1].next = nodes[i];
		}
		nodes[i].next = null;
		return nodes[0];
	}
	
	// for test1's partition
	public static void arrPartition(Node[] nodes, int pivot) {
		
		int small = -1;
		int more = nodes.length;
		int index = 0;
		
		while(index != more) {
			if(nodes[index].value < pivot) {
				swap(nodes, index++, ++small);
			}else if(nodes[index].value > pivot) {
				swap(nodes, index, --more);
			}else {
				index++;
			}
		}		
	}
	
	// swap
	public static void swap(Node[] nodes, int i, int j) {
		Node tmp = nodes[i];
		nodes[i] = nodes[j];
		nodes[j] = tmp;
	}
	
	
	// list partition2
	public static Node listPatition2(Node head, int pivot) {
	
		if(head == null) {
			return null;
		}
		
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node mH = null;
		Node mT = null;
		Node next = null;
		while(head != null) {
			next = head.next;
			head.next = null;
			if(head.value < pivot) {
				if(sH == null) {
					sH = head;
					sT = head;
				}else {
					sT.next = head;
					sT = head;
				}
			}else if(head.value == pivot) {
				if(eH == null) {
					eH = head;
					eT = head;
				}else {
					eT.next = head;
					eT = head;
				}
			}else {
				if(mH == null) {
					mH = head;
					mT = head;
				}else {
					mT.next = head;
					mT = head;
				}
			}
			head = next;
		}
		
		if(sT != null) {
			sT.next = eH;
			eT = eT != null ? eT : sT;
		}
		
		if(eT != null) {
			eT.next = mH;
		}
		
		return sH != null ? sH : (eH != null ? eH : mH);
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


